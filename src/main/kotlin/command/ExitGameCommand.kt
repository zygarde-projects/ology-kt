package command

import command.base.NoArgCommand
import d2r.D2RController

object ExitGameCommand : NoArgCommand("exit") {
  override suspend fun handle() {
    D2RController.d2rRunning(true)
    D2RController.exitGame()
  }
}
