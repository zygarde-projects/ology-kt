package d2r

import NodeJS.Timeout
import conf.ClientConfig
import d2r.constants.GeneralConstants
import d2r.constants.ImageMatching
import d2r.constants.MouseLocations.Lobby.fireRiver
import d2r.constants.MouseLocations.Lobby.moveWhenInFireRiver
import extension.CoroutineExtensions.launch
import extension.log
import extension.wait
import extension.waitRandomly
import external.wincontrol.WinControl
import timers.clearInterval
import timers.setInterval

object BoController {
  private var boIntervalId: Timeout? = null

  suspend fun start() {
    ScreenController.oneOfImagesIn(ImageMatching.act4tp)?.region?.run {
      MouseController.clickOnRegionCenter(this)
      ScreenController.oneOfImagesIn(ImageMatching.wpMenuTabAct4)?.region?.run {
        MouseController.clickOn(fireRiver).wait(3000)
        when (ScreenController.oneOfImagesIn(ImageMatching.fireRiver)) {
          null -> log("fireRiverMark not detected, bo won't start")
          else -> {
            MouseController.clickOn(moveWhenInFireRiver)
            boIntervalId = setInterval({ launch { run() } }, 2000)
          }
        }
      }
    }
  }

  fun stop() = boIntervalId?.run {
    clearInterval(this)
    boIntervalId = null
  }

  private suspend fun run() {
    if (WinControl.Window.getForeground()?.getTitle() != GeneralConstants.gameWindowTitle) {
      log("D2R not active, skipping BO")
      return
    }

    if (ScreenController.oneOfImagesIn(ImageMatching.wpInFireRiverAct4)?.region == null) {
      val keyboardKeys = ClientConfig.get("bo:keys").split("|")
      keyboardKeys.forEach {
        KeyboardController.pressAndReleaseKey(it.toInt())
        MouseController.rightClick().waitRandomly()
      }
    }
  }
}
