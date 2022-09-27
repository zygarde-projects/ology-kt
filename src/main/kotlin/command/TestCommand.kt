package command

import command.base.NoArgCommand
import d2r.D2RController
import extension.launch
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

object TestCommand : NoArgCommand("test") {
    @OptIn(ExperimentalTime::class)
    override fun handle() {
        launch {
            println("D2R Running: ${D2RController.d2rRunning(true)}")
            try {
                measureTime {
                    val isInGame = D2RController.isInGame()
                    println("D2R In Game: $isInGame")
                }.let { println(it) }

            } catch (e: Throwable) {
                println(e)
            }
        }
    }
}
