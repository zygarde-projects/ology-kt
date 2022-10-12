package d2r

import NodeJS.Timeout
import conf.ClientConfig
import d2r.constants.ImageMatching
import d2r.constants.MouseLocations.Lobby.fireRiver
import d2r.constants.MouseLocations.Lobby.moveWhenInFireRiver
import extension.CoroutineExtensions.launch
import extension.log
import extension.wait
import extension.waitRandomly
import kotlinx.coroutines.delay
import timers.clearInterval
import timers.setInterval
import kotlin.js.Date

object BoController {
  private var boIntervalId: Timeout? = null

  suspend fun start() {
    ScreenController.oneOfImagesIn(ImageMatching.act4tp)?.region?.run {
      MouseController.clickOnRegionCenter(this).log("click on act4tpCenter ${Date.now()}")
      delay(5000)
      ScreenController.oneOfImagesIn(ImageMatching.wpMenuTabAct4)?.region?.run {
        delay(2000)
        MouseController.clickOn(fireRiver).log("click on fireRiver ${Date.now()}").wait(3000)
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
    if (ScreenController.oneOfImagesIn(ImageMatching.wpInFireRiverAct4)?.region == null) {
      val keyboardKeys = ClientConfig.get("bo:keys").split("|")
      keyboardKeys.forEach {
        KeyboardController.pressAndReleaseKey(it.toInt())
        MouseController.rightClick().waitRandomly()
      }
    }
  }
}
