package command

import command.base.BaseCommand
import d2r.D2RController
import extension.launch

object TestCommand : BaseCommand<Unit>("test") {
    override fun handle(args: Unit) {
        launch {
            println("D2R Running: ${D2RController.isGameRunning()}")
            val isInGame = D2RController.isInGame()
            println("D2R In Game: $isInGame")
            if (isInGame) {
                println("D2R Exit Game")
                D2RController.exitGame()
            }
        }
    }
}
