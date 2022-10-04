package d2r

import conf.ClientConfig
import d2r.action.*
import d2r.action.base.InGameAction
import d2r.action.base.MoveAction
import d2r.action.base.SkillCastAction
import d2r.action.skill.AssassinTrap
import d2r.action.skill.BarbBo
import d2r.constants.GeneralConstants.gameWindowTitle
import d2r.constants.ImageMatching
import d2r.constants.ImageMatching.GAME_STATUS_ALL
import d2r.constants.MouseLocations.InGame.btnExitGame
import d2r.constants.MouseLocations.Lobby
import extension.log
import extension.wait
import external.nuttree.Key
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
    Act4WaitTp,
    Act5WaitTp,
    // post enter tp
    BarbBo,
    AssassinTrap,
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

  suspend fun exitGame() {
    stopSkillCast()

    keyboard.pressKey(Key.LeftShift).await()
    MouseController.clickOn(btnExitGame)
    keyboard.releaseKey(Key.LeftShift).await()

    keyboard.type(Key.Escape).await().wait(1000)
    MouseController.clickOn(btnExitGame)
  }

  suspend fun makeGame(
    name: String,
    password: String,
    difficulty: GameDifficulty = GameDifficulty.HELL
  ) = withD2rRunning(true) {
    MouseController.clickOn(btnExitGame).wait(500)

    val gameStatus = detectGameStatus()
    if (gameStatus == null) {
      println("cannot detect game status")
      return@withD2rRunning
    }

    if (gameStatus.isInGame()) {
      println("inGame, exiting game")
      exitGame().wait(1500)
    } else if (gameStatus.isInLobby()) {
      println("inLobby")
    }

    MouseController.clickOn(Lobby.makeGameTab).wait(1000).log("game name=$name, password=$password")
    MouseController.clickOn(Lobby.makeGameInputName)
    KeyboardController
      .inputGameNameAndPassword(name = name, password = password)
      .wait(1000)

    MouseController.clickOn(difficulty.btnPoint).wait(200)

    KeyboardController.submitGameForm().wait(5000)

    val gameStatusAfterMakeGame = detectGameStatus()
    if (gameStatusAfterMakeGame?.isInGame() == true) {
      log("Game $name created")
    } else {
      log("Failed to create game, something wrong...")
    }
  }

  suspend fun joinGame(name: String, password: String): Boolean = withD2rRunning(true) {
    stopSkillCast()

    delay(ClientConfig.get("join_delay").toLongOrNull() ?: 0L)
    val gameStatus = detectGameStatus()
    if (gameStatus == null) {
      println("cannot detect game status")
      return@withD2rRunning false
    }

    if (gameStatus.isInGame()) {
      println("inGame, exiting game")
      exitGame().wait(1500)
    }

    MouseController.clickOn(Lobby.joinGameTab).wait(100)
    MouseController.clickOn(Lobby.joinGameInputName).wait(100)
    KeyboardController
      .inputGameNameAndPassword(name = name, password = password)
      .wait(1000)
    MouseController.clickOn(Lobby.joinGameRefresh).wait(1000)
    KeyboardController.submitGameForm()

    delay(ClientConfig.get("join_loading_delay").toLongOrNull() ?: 8000L)

    val gameStatusAfterJoinGame = detectGameStatus()
    if (gameStatusAfterJoinGame?.isInGame() == true) {
      log("Game $name joined")

      if (ClientConfig.get("post_join_game:switch_to_legacy") == "true") {
        KeyboardController.pressAndReleaseKey(Key.G)
        delay(1000)
      }
    } else {
      log("Did not detect in game or not...")
    }

    gameStatusAfterJoinGame?.isInGame() == true
  }

  suspend fun startBo() {
    BoController.stop()
    BoController.start()
  }

  fun allActionNames() = actionMap.keys

  fun allActions() = actionMap.values

  suspend fun execute(actionName: String) = withD2rRunning(true) {
    val action = actionMap[actionName] ?: throw IllegalArgumentException("action $actionName not found")
    if (action is SkillCastAction) {
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
