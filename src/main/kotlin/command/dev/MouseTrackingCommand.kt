package command.dev

import command.base.NoArgCommand
import extension.await
import extension.launch
import external.nuttree.mouse
import external.nuttree.screen
import timers.setInterval

object MouseTrackingCommand : NoArgCommand("mouse-tracking") {
    override fun handle() {
        launch {
            val width = screen.width().await()
            val height = screen.height().await()
            println("screen $width x $height")
        }


        println("start mouse tracking")
        setInterval({
            mouse.getPosition().then {
                println("position: $it")
            }
        }, 1000)
    }
}
