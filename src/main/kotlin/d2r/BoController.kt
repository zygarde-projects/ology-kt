package d2r

import NodeJS.Timeout
import conf.ClientConfig
import d2r.constants.GeneralConstants
import d2r.constants.MouseLocations.Lobby.fireRiver
import d2r.constants.MouseLocations.Lobby.moveWhenInFireRiver
import extension.launch
import extension.log
import extension.wait
import extension.waitRandomly
import external.nuttree.OptionalSearchParameters
import external.nuttree.imageResource
import external.nuttree.screen
import external.wincontrol.WinControl
import kotlinx.coroutines.await
import timers.clearInterval
import timers.setInterval

object BoController {
  private var boIntervalId: Timeout? = null
  private val option = OptionalSearchParameters(searchMultipleScales = true, confidence = 0.9)

  suspend fun start() {
    ScreenController.matchImage("act4wp.png")?.run {
      MouseController.clickOnRegionCenter(this)
      ScreenController.matchImage("wp_menu_tab_act4.png")?.run {
        MouseController.clickOn(fireRiver).wait(3000)
        val fireRiverMark = ScreenController.oneOfImagesIn(
          listOf(
            "fire_river_mark_1.png",
            "fire_river_mark_2.png",
            "fire_river_mark_3.png"
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

    runCatching { screen.find(imageResource("wp_in_fire_river.png"), option).await() }
      .onFailure {
        val keyboardKeys = ClientConfig.get("bo:keys").split("|")
        keyboardKeys.forEach {
          KeyboardController.pressAndReleaseKey(it.toInt())
          MouseController.rightClick().waitRandomly()
        }
      }
  }
}
