package command

import command.base.NoArgCommand
import d2r.D2RController
import extension.launch

object TestCommand : NoArgCommand("test") {
    override fun handle() {
        launch {
            println("D2R Running: ${D2RController.d2rRunning(true)}")
            val isInGame = D2RController.isInGame()
            println("D2R In Game: $isInGame")
        }
    }
}
