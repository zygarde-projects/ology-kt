package d2r

import d2r.action.Act1WaitTp
import d2r.action.FindAndEnterTp
import d2r.action.base.InGameAction
import d2r.constants.GeneralConstants.gameWindowTitle
import d2r.constants.ImageMatching
import d2r.constants.ImageMatching.IN_GAME_ALL
import d2r.constants.MouseLocations.InGame.btnExitGame
import d2r.constants.MouseLocations.Lobby
import extension.log
import extension.wait
import external.nuttree.Key
import external.nuttree.keyboard
import external.wincontrol.WinControl.Window
import kotlinx.coroutines.await
import types.GameDifficulty
import types.InGameStatus

object D2RController {

  private val actionMap: Map<String, InGameAction> = listOf(
    FindAndEnterTp,
    Act1WaitTp,
  ).associateBy { it::class.simpleName.orEmpty() }

  fun d2rRunning(switchToForegroundWhenRunning: Boolean = false): Boolean {
    val d2r = Window.getByTitle(gameWindowTitle)
    if (switchToForegroundWhenRunning && d2r != null) {
      d2r.setForeground()
    }
    return d2r != null
  }

  suspend fun detectGameStatus(): InGameStatus? {
    val matchResult = ScreenController.oneOfImagesIn(IN_GAME_ALL)

    val matchedImage = matchResult?.image
    if (matchedImage != null) {
      if (ImageMatching.inGame.containsKey(matchedImage)) {
        return InGameStatus.IN_GAME
      }
      if (ImageMatching.inGameLegacy.containsKey(matchedImage)) {
        return InGameStatus.IN_GAME_LEGACY
      }
      if (ImageMatching.inLobby.containsKey(matchedImage)) {
        return InGameStatus.LOBBY
      }
    }
    return null
  }

  suspend fun exitGame() {
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
    KeyboardController.inputGameNameAndPassword(name = name, password = password).wait(1000)

    MouseController.clickOn(difficulty.btnPoint).wait(200)

    KeyboardController.submitGameForm().wait(3000)

    val gameStatusAfterMakeGame = detectGameStatus()
    if (gameStatusAfterMakeGame?.isInGame() == true) {
      log("Game $name created")
    } else {
      log("Failed to create game, something wrong...")
    }
  }

  suspend fun joinGame(name: String, password: String) = withD2rRunning(true) {
    val gameStatus = detectGameStatus()
    if (gameStatus == null) {
      println("cannot detect game status")
      return@withD2rRunning
    }

    if (gameStatus.isInGame()) {
      println("inGame, exiting game")
      exitGame().wait(1500)
    }

    MouseController.clickOn(Lobby.joinGameTab).wait(100)
    MouseController.clickOn(Lobby.joinGameInputName).wait(100)
    KeyboardController.inputGameNameAndPassword(name = name, password = password).wait(100)
    MouseController.clickOn(Lobby.joinGameRefresh).wait(1000)
    KeyboardController.submitGameForm().wait(3000)
    val gameStatusAfterJoinGame = detectGameStatus()
    if (gameStatusAfterJoinGame?.isInGame() == true) {
      log("Game $name joined")
    } else {
      log("Did not detect in game or not...")
    }
  }

  suspend fun startBo() {
    BoController.stop()
    BoController.start()
  }

  fun allActionNames() = actionMap.keys

  suspend fun execute(actionName: String) {
    val action = actionMap[actionName] ?: throw IllegalArgumentException("action $actionName not found")
    action.exec()
  }

  private suspend fun withD2rRunning(switchToForegroundWhenRunning: Boolean = false, block: suspend () -> Unit) {
    if (d2rRunning(switchToForegroundWhenRunning)) {
      block()
    } else {
      log("D2R not running, please launch D2R and go to lobby first")
    }
  }
}
