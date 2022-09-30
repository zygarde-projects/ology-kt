package d2r

import d2r.constants.ImageMatching
import extension.CoroutineExtensions.launch
import extension.toImageResource
import external.node.AbortController
import external.node.AbortSignal
import external.nuttree.Image
import external.nuttree.OptionalSearchParameters
import external.nuttree.Region
import external.nuttree.screen
import kotlinx.coroutines.await
import types.MatchedImage
import types.MatchingImageRequest
import kotlin.js.Promise

object ScreenController : WindowActor {
  suspend fun matchImage(
    imageName: String,
    req: MatchingImageRequest = ImageMatching.DEFAULT,
    abortSignal: AbortSignal? = null,
  ): Region? {
    val image = imageName.toImageResource().await()
    val region = req.detectInRegion?.let { dir -> withTranslatedRegion(dir) { it } }
    return matchImageInternal(
      image = image,
      currentRetry = 1,
      maxRetry = req.maxRetry,
      confidence = req.baseConfidence,
      lowerConfidenceWhenFail = req.lowerConfidenceWhenFail,
      timeoutMs = req.timeoutMs,
      intervalMs = req.intervalMs,
      searchRegion = region,
      abortSignal = abortSignal,
    )
  }

  suspend fun oneOfImagesIn(
    images: List<String>
  ): MatchedImage? {
    return oneOfImagesIn(images.associateWith { ImageMatching.DEFAULT })
  }

  suspend fun oneOfImagesIn(
    reqMap: Map<String, MatchingImageRequest>
  ): MatchedImage? {
    val abortControllers = mutableListOf<AbortController>()
    val list = reqMap
      .map { e ->
        val abortController = AbortController()
        abortControllers.add(abortController)
        Promise<MatchedImage?> { resolve, _ ->
          launch {
            val matchedRegion = matchImage(e.key, e.value, abortController.signal)
            resolve(matchedRegion?.let { MatchedImage(e.key, it) })
          }
        }
      }
      .toTypedArray()
    return Promise
      .race(list)
      .then {
        for (abortController in abortControllers) {
          abortController.abort()
        }
        it
      }.await()
  }

  private suspend fun matchImageInternal(
    image: Image,
    currentRetry: Int = 1,
    maxRetry: Int = 5,
    confidence: Double = 0.9,
    lowerConfidenceWhenFail: Double = 0.025,
    timeoutMs: Int = 2000,
    intervalMs: Int = 500,
    searchRegion: Region? = null,
    abortSignal: AbortSignal? = null,
  ): Region? {
    if (abortSignal?.aborted == true) {
      return null
    }
    val region = screen
      .waitFor(
        templateImage = image,
        timeoutMs = timeoutMs,
        updateInterval = intervalMs,
        OptionalSearchParameters(
          searchRegion = searchRegion,
          confidence = confidence,
          searchMultipleScales = true,
          abortSignal = abortSignal,
        )
      )
      .await()

    return if (region == null && currentRetry <= maxRetry) {
      matchImageInternal(
        image = image,
        currentRetry = currentRetry + 1,
        maxRetry = maxRetry,
        confidence = confidence - lowerConfidenceWhenFail,
        lowerConfidenceWhenFail = lowerConfidenceWhenFail,
        timeoutMs = timeoutMs,
        intervalMs = intervalMs,
        searchRegion = searchRegion,
        abortSignal = abortSignal,
      )
    } else {
      region
    }
  }

}
