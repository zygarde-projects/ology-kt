package d2r

import conf.ClientConfig
import conf.HostConfig
import conf.SystemConfig
import d2r.action.*
import d2r.action.base.InGameAction
import d2r.action.base.MoveAction
import d2r.action.base.SkillCastAction
import d2r.action.skill.*
import d2r.constants.GeneralConstants.gameWindowTitle
import d2r.constants.ImageMatching
import d2r.constants.ImageMatching.GAME_STATUS_ALL
import d2r.constants.MouseLocations.InGame.btnExitGame
import d2r.constants.MouseLocations.Lobby
import extension.log
import extension.wait
import external.nuttree.Key
import external.nuttree.Point
import external.nuttree.keyboard
import external.wincontrol.WinControl.Window
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import types.GameDifficulty
import types.InGameStatus
import types.MoveDirection

object D2RController {

  private val runningSkillActions: MutableList<SkillCastAction> = mutableListOf()

  private val actionMap: Map<String, InGameAction> = listOf(
    // post join game
    Act1WaitTp,
    Act2WaitTp,
    Act3WaitTp,
    Act5WaitTp,
    // post enter tp
    BarbBo,
    AssassinTrap,
    NecroSummonSkeleton,
    NecroSummonGolem,
    NecroCurse,
    SorcBlizzard,
    SorcMeteor,
    SorcHydra,
    PalFistOfHeaven,
  ).associateBy { it::class.simpleName.orEmpty() }

  fun d2rRunning(switchToForegroundWhenRunning: Boolean = false): Boolean {
    val d2r = Window.getByTitle(gameWindowTitle)
    if (switchToForegroundWhenRunning && d2r != null) {
      d2r.setForeground()
    }
    return d2r != null
  }

  suspend fun detectGameStatus(): InGameStatus? = withD2rRunning(true) {
    val matchResult = ScreenController.oneOfImagesIn(GAME_STATUS_ALL)
    val matchedImage = matchResult?.image
    if (matchedImage != null) {
      if (ImageMatching.inGame.containsKey(matchedImage)) {
        InGameStatus.IN_GAME
      } else if (ImageMatching.inGameLegacy.containsKey(matchedImage)) {
        InGameStatus.IN_GAME_LEGACY
      } else if (ImageMatching.inLobby.containsKey(matchedImage)) {
        InGameStatus.LOBBY
      } else {
        null
      }
    } else {
      null
    }
  }

  suspend fun exitGame(currentRetry: Int = 1, maxRetry: Int = 1) {
    stopSkillCast()

    if (SystemConfig.get("joy_stick").toBoolean()) { // switch out joystick ui
      MouseController.clickOn(btnExitGame).wait(1000)
    }

    val gameStatus = detectGameStatus() ?: throw IllegalStateException("cannot detect game status")
    if (!gameStatus.isInGame()) {
      println("exitGame: not in game")
      return
    }

    keyboard.type(Key.Escape).await().wait(1000)
    MouseController.clickOn(btnExitGame)

    delay(1000)
    val gameStatusAfterExit = detectGameStatus() ?: throw IllegalStateException("cannot detect game status")
    if (gameStatusAfterExit == InGameStatus.LOBBY) {
      println("exitGame: now in lobby")
    } else if (gameStatusAfterExit.isInGame() && currentRetry <= maxRetry) {
      println("exitGame: did not detect in lobby, try exitGame again in retry $currentRetry")
      MouseController.clickOn(Point(0, 0))
      exitGame(currentRetry + 1, maxRetry)
    } else {
      println("exitGame: failed to exitGame after $currentRetry retry")
    }
  }

  suspend fun makeGame(
    name: String,
    password: String,
    difficulty: GameDifficulty = GameDifficulty.HELL
  ) = withD2rRunning(true) {
    exitGame()

    MouseController.clickOn(Lobby.makeGameTab).wait(1000).log("game name=$name, password=$password")
    MouseController.clickOn(Lobby.makeGameInputName)
    KeyboardController
      .inputGameNameAndPassword(name = name, password = password)
      .wait(1000)

    MouseController.clickOn(difficulty.btnPoint).wait(200)

    KeyboardController.submitGameForm()

    delay(HostConfig.get("make_game_loading_delay").toLongOrNull() ?: 5000L)

    if (HostConfig.get("make_game_wait_in_game") === "true") {
      val gameStatusAfterMakeGame = detectGameStatus()
      if (gameStatusAfterMakeGame?.isInGame() == true) {
        log("Game $name created")
      } else {
        log("Failed to create game, game status is $gameStatusAfterMakeGame")
      }
    }
  }

  suspend fun joinGame(name: String, password: String): Boolean = withD2rRunning(true) {
    exitGame()

    delay(ClientConfig.get("join_delay").toLongOrNull() ?: 0L)

    MouseController.clickOn(Lobby.joinGameTab).wait(100)
    MouseController.clickOn(Lobby.joinGameInputName).wait(300)
    KeyboardController
      .inputGameNameAndPassword(name = name, password = password)
      .wait(1000)

    // click on search input to prevent focus on searched game
    MouseController.clickOn(Lobby.joinGameSearch).wait(300)

    MouseController.clickOn(Lobby.joinGameBth)

    val joinLoadingDelay = ClientConfig.get("join_loading_delay").toLongOrNull()
    log("joinLoadingDelay: $joinLoadingDelay")
    delay(ClientConfig.get("join_loading_delay").toLongOrNull() ?: 8000L)

    val gameStatusAfterJoinGame = detectGameStatus()
    if (gameStatusAfterJoinGame?.isInGame() == true) {
      log("Game $name joined")

      if (ClientConfig.get("post_join_game:switch_to_legacy") == "true") {
        delay(500)
        KeyboardController.pressAndReleaseKey(Key.G)
        delay(500)
      }
      if (ClientConfig.get("post_join_game:disable_avatar") == "true") {
        KeyboardController.pressAndReleaseKey(Key.Z)
      }
    } else {
      log("Did not detect in game or not...")
    }

    gameStatusAfterJoinGame?.isInGame() == true
  }

  suspend fun startBo() = withD2rRunning(true) {
    log("start BO")
    BoController.stop()
    BoController.start()
  }

  fun allActionNames() = actionMap.keys

  fun allActions() = actionMap.values

  suspend fun execute(actionName: String) = withD2rRunning(true) {
    val action = actionMap[actionName] ?: throw IllegalArgumentException("action $actionName not found")
    if (action is SkillCastAction) {
      if (runningSkillActions.contains(action)) {
        println("skill $actionName already running")
        return@withD2rRunning
      }
      runningSkillActions.add(action)
    }
    action.exec()
  }

  suspend fun enterTp() = withD2rRunning(true) {
    stopSkillCast()
    FindAndEnterTp.exec()
  }

  suspend fun move(direction: MoveDirection, distance: Int = 1) = withD2rRunning(true) {
    MoveAction.move(direction, distance)
  }

  fun stopSkillCast() {
    for (runningSkillAction in runningSkillActions) {
      runningSkillAction.stop()
    }
    runningSkillActions.clear()
  }

  private suspend fun <T> withD2rRunning(switchToForegroundWhenRunning: Boolean = false, block: suspend () -> T): T {
    return if (d2rRunning(switchToForegroundWhenRunning)) {
      block()
    } else {
      throw IllegalStateException("D2R not running, please launch D2R and go to lobby first")
    }
  }
}
