package d2r

import extension.await
import extension.launch
import extension.toImageResource
import external.nuttree.Region
import external.nuttree.screen
import kotlin.js.Promise

object ScreenController {
    suspend fun checkImage(templateImageName: String, currentRetry: Int = 1, maxRetry: Int = 4): Region? {
        println("checkImage $templateImageName")
        screen.config.confidence = 0.9 // TODO: to config
        val region = screen
            .waitFor(
                templateImage = templateImageName.toImageResource(),
                timeoutMs = 3000, // TODO: to config
                updateInterval = 500
            )
            .await()

        return if (region == null && currentRetry <= maxRetry) {
            checkImage(
                templateImageName = templateImageName,
                currentRetry = currentRetry + 1,
                maxRetry = maxRetry
            )
        } else {
            region
        }
    }

    suspend fun oneOfImagesIn(templateImageNames: List<String>, maxRetry: Int = 1): Region? {
        val list = templateImageNames
            .map {
                Promise<Region?> { resolve, _ ->
                    launch { resolve(checkImage(it, maxRetry = maxRetry)) }
                }
            }
            .toTypedArray()
        return Promise.race(list).await()
    }
}
