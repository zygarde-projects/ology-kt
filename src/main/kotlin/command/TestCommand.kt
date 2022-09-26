package command

import command.base.NoArgCommand
import d2r.D2RController
import extension.launch

object TestCommand : NoArgCommand("test") {
    override fun handle() {
        launch {
            println("D2R Running: ${D2RController.d2rRunning()}")
            val isInGame = D2RController.isInGame()
            println("D2R In Game: $isInGame")
            if (isInGame) {
                println("D2R Exit Game")
                D2RController.exitGame()
            }
        }
    }
}
