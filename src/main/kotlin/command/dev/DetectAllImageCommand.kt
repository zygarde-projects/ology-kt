package command.dev

import NodeJS.Timeout
import command.base.NoArgCommand
import d2r.D2RController
import d2r.WindowActor
import d2r.constants.ImageMatching
import d2r.constants.ImageMatching.tpLegacy
import extension.DimensionExtensions.translateRegion
import extension.launch
import extension.toImageResource
import external.nuttree.OptionalSearchParameters
import external.nuttree.screen

object DetectAllImageCommand : NoArgCommand("detect-all"), WindowActor {

  var intervalId: Timeout? = null
  override fun handle() {
    suspend fun detect() = withWindowDimension { dimensions ->
      ImageMatching.IN_GAME_ALL
        .plus(
          tpLegacy
        )
        .map { e ->
          screen
            .find(
              e.key.toImageResource(),
              OptionalSearchParameters(
                searchRegion = e.value.detectInRegion?.let { dimensions.translateRegion(it) },
                confidence = e.value.baseConfidence,
                searchMultipleScales = true,
              ),
            )
            .then {
              println("detect ${e.key} at $it")
            }
            .catch {
              val msg = kotlin.runCatching {
                "$it".replace(".*Best match".toRegex(), "")
              }
              println("detect ${e.key} failed ${msg}")
            }
        }
    }

    println("start detect images")
    D2RController.d2rRunning(true)
//    intervalId = setInterval({
    launch {
      detect()
    }
//    }, 5000)

  }
}
