package command

import command.base.NoArgCommand
import d2r.D2RController
import extension.launch

object ExitGameCommand : NoArgCommand("exit") {
  override fun handle() {
    launch {
      D2RController.d2rRunning(true)
      D2RController.exitGame()
    }
  }
}
