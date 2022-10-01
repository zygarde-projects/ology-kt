package d2r

import NodeJS.Timeout
import conf.ClientConfig
import d2r.constants.GeneralConstants
import d2r.constants.ImageMatching
import d2r.constants.MouseLocations.Lobby.fireRiver
import d2r.constants.MouseLocations.Lobby.moveWhenInFireRiver
import extension.*
import extension.CoroutineExtensions.launch
import external.nuttree.OptionalSearchParameters
import external.nuttree.screen
import external.wincontrol.WinControl
import kotlinx.coroutines.await
import timers.clearInterval
import timers.setInterval

object BoController {
  private var boIntervalId: Timeout? = null
  private val option = OptionalSearchParameters(searchMultipleScales = true, confidence = 0.9)

  suspend fun start() {
    ScreenController.oneOfImagesIn(ImageMatching.act4tp)?.region?.run {
      MouseController.clickOnRegionCenter(this)
      ScreenController.oneOfImagesIn(ImageMatching.wpMenuTabAct4)?.region?.run {
        MouseController.clickOn(fireRiver).wait(3000)
        val fireRiverMark = ScreenController.oneOfImagesIn(
          listOf(
            "in-game/fire_river_mark_1.png",
            "in-game/fire_river_mark_2.png",
            "in-game/fire_river_mark_3.png"
          )
        )

        when (fireRiverMark) {
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

    runCatching { screen.find("in-game/wp_in_fire_river.png".toImageResource(), option).await() }
      .onFailure {
        val keyboardKeys = ClientConfig.get("bo:keys").split("|")
        keyboardKeys.forEach {
          KeyboardController.pressAndReleaseKey(it.toInt())
          MouseController.rightClick().waitRandomly()
        }
      }
  }
}
