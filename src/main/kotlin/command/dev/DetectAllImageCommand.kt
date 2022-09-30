package command.dev

import command.base.NoArgCommand
import d2r.D2RController
import d2r.WindowActor
import d2r.constants.ImageMatching
import d2r.constants.ImageMatching.tpLegacy
import extension.DimensionExtensions.translateRegion
import extension.toImageResource
import external.nuttree.OptionalSearchParameters
import external.nuttree.screen
import kotlin.js.Promise

object DetectAllImageCommand : NoArgCommand("detect-all"), WindowActor {

  override suspend fun handle() {
    suspend fun detect() = withWindowDimension { dimensions ->
      ImageMatching.IN_GAME_ALL
        .plus(
          tpLegacy
        )
        .map { e ->
          val searchRegion = e.value.detectInRegion?.let { dimensions.translateRegion(it) }
          screen
            .find(
              e.key.toImageResource(),
              OptionalSearchParameters(
                searchRegion = searchRegion,
                confidence = e.value.baseConfidence,
                searchMultipleScales = true,
              ),
            )
            .then { "detected at $it" }
            .catch {
              val msg = kotlin
                .runCatching {
                  "$it".replace(".*Best match".toRegex(), "")
                }
                .getOrDefault("$it")
              "failed ${msg}"
            }
            .then {
              mapOf(
                "msg" to it,
                "img" to e.key,
                "searchRegion" to searchRegion,
              )
            }
        }
        .toTypedArray()
        .let {
          Promise.all(it)
            .then {
              console.asDynamic().table(it)
            }
        }
    }

    println("start detect images")
    D2RController.d2rRunning(true)
    detect()
  }
}
