package d2r

import NodeJS.Timeout
import conf.ClientConfig
import d2r.constants.ImageMatching
import d2r.constants.MouseLocations.Lobby.fireRiver
import d2r.constants.MouseLocations.Lobby.moveWhenInFireRiver
import d2r.constants.MouseLocations.Lobby.tpAct4
import extension.CoroutineExtensions.launch
import extension.log
import extension.wait
import extension.waitRandomly
import kotlinx.coroutines.delay
import timers.clearInterval
import timers.setInterval
import types.MatchedImage
import utils.retry
import kotlin.js.Date

object BoController {
  private var boIntervalId: Timeout? = null

  suspend fun start() {
    ScreenController.oneOfImagesIn(ImageMatching.act4tp)?.region?.run {
      delay(3000)
      MouseController.clickOnRegionCenter(this).wait(4000)
      retry(3) { findingWpMenuTabAct4() }?.region?.run {
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

  private suspend fun findingWpMenuTabAct4(): MatchedImage? {
    var wpMenuTabAct4 = ScreenController.oneOfImagesIn(ImageMatching.wpMenuTabAct4)
    if (wpMenuTabAct4 == null) {
      delay(1000)
      MouseController.clickOn(tpAct4).wait(500)
      wpMenuTabAct4 = ScreenController.oneOfImagesIn(ImageMatching.wpMenuTabAct4)
    }

    return wpMenuTabAct4
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
