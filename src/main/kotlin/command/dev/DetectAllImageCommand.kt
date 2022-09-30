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
import kotlin.js.Date
import kotlin.js.Promise

object DetectAllImageCommand : NoArgCommand("detect-all"), WindowActor {

  data class DetectResult(
    val image: String,
    val time: String,
    val region: String?,
    val msg: String,
  )

  override suspend fun handle() {
    suspend fun detect() = withWindowDimension { dimensions ->
      ImageMatching.IN_GAME_ALL
        .plus(
          tpLegacy
        )
        .map { e ->
          val searchRegion = e.value.detectInRegion?.let { dimensions.translateRegion(it) }
          val st = Date().getTime()
          screen
            .find(
              e.key.toImageResource(),
              OptionalSearchParameters(
                searchRegion = searchRegion,
                confidence = e.value.baseConfidence,
                searchMultipleScales = true,
              ),
            )
            .then { "left=${it.left.toInt()},top=${it.top.toInt()}, width=${it.width.toInt()}, height=${it.height.toInt()}" }
            .catch {
              val msg = kotlin
                .runCatching {
                  "$it".replace(".*Best match".toRegex(), "")
                }
                .getOrDefault("$it")
              "failed $msg"
            }
            .then {
              DetectResult(
                image = e.key,
                time = "${Date().getTime() - st}ms",
                region = searchRegion?.toString() ?: "Full Screen",
                msg = it,
              )
            }
        }
        .toTypedArray()
        .let {
          Promise.all(it)
            .then {
              console.asDynamic().table(it.sortedBy { r -> r.image }.toTypedArray())
            }
        }
    }

    println("start detect images")
    D2RController.d2rRunning(true)
    detect()
  }
}
