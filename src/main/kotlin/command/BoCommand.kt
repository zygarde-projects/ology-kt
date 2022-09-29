package command

import command.base.NoArgCommand
import d2r.D2RController
import extension.launch

object BoCommand : NoArgCommand("bo") {
  override fun handle() {
    launch { D2RController.startBo() }
  }
}
