package command

import command.base.NoArgCommand
import d2r.D2RController

object BoCommand : NoArgCommand("bo") {
  override suspend fun handle() {
    D2RController.startBo()
  }
}
