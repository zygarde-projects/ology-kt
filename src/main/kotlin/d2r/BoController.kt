package d2r

import NodeJS.Timeout
import conf.ClientConfig
import extension.launch
import extension.waitRandomly
import external.nuttree.OptionalSearchParameters
import external.nuttree.imageResource
import external.nuttree.screen
import kotlinx.coroutines.await
import timers.clearInterval
import timers.setInterval

object BoController {
    private var boIntervalId: Timeout? = null
    private val option = OptionalSearchParameters(searchMultipleScales = true, confidence = 0.9)

    suspend fun start() {
        boIntervalId = setInterval({ launch { run() } }, 2000)
    }

    fun stop() = boIntervalId?.run {
        clearInterval(this)
        boIntervalId = null
    }

    private suspend fun run() {
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
