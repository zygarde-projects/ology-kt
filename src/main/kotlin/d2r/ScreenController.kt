package d2r

import d2r.constants.ImageMatching
import extension.await
import extension.launch
import extension.toImageResource
import external.nuttree.Image
import external.nuttree.OptionalSearchParameters
import external.nuttree.Region
import external.nuttree.screen
import types.MatchingImageRequest
import kotlin.js.Promise
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
object ScreenController : WindowActor {
    suspend fun matchImage(imageName: String, req: MatchingImageRequest = ImageMatching.DEFAULT): Region? {
        val image = imageName.toImageResource().await() ?: throw IllegalArgumentException("image $imageName not found")
        val region = req.detectInRegion?.let { dir -> withTranslatedRegion(dir) { it } }
        return measureTimedValue {
            matchImageInternal(
                image = image,
                currentRetry = 1,
                maxRetry = req.maxRetry,
                confidence = req.baseConfidence,
                lowerConfidenceWhenFail = req.lowerConfidenceWhenFail,
                timeoutMs = req.timeoutMs,
                intervalMs = req.intervalMs,
                searchRegion = region
            )
        }
            .also { println("match $imageName at ${it.value} cost ${it.duration}") }
            .value
    }

    suspend fun oneOfImagesIn(
        images: List<String>
    ): Region? {
        return oneOfImagesIn(
            images.associateWith { ImageMatching.DEFAULT }
        )
    }

    suspend fun oneOfImagesIn(
        reqMap: Map<String, MatchingImageRequest>
    ): Region? {
        val list = reqMap
            .map { e ->
                Promise<Region?> { resolve, _ ->
                    launch { resolve(matchImage(e.key, e.value)) }
                }
            }
            .toTypedArray()
        return Promise
            .race(list)
            .then {
                println("race success $it")
                it
            }.await()
    }

    private suspend fun matchImageInternal(
        image: Image,
        currentRetry: Int = 1,
        maxRetry: Int = 5,
        confidence: Double = 0.9,
        lowerConfidenceWhenFail: Double = -0.025,
        timeoutMs: Int = 2000,
        intervalMs: Int = 500,
        searchRegion: Region? = null,
    ): Region? {
        val region = screen
            .waitFor(
                templateImage = image,
                timeoutMs = timeoutMs,
                updateInterval = intervalMs,
                OptionalSearchParameters(
                    searchRegion = searchRegion,
                    confidence = confidence,
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
                searchRegion = searchRegion
            )
        } else {
            region
        }
    }

}
