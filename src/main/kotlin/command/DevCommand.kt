package command

import command.dev.MouseTrackingCommand
import external.yargs.Argv
import external.yargs.CommandModule

object DevCommand : CommandModule<dynamic, Unit> {
  override var command: String = "dev [action]"

  override var builder: (args: Argv<Unit>) -> dynamic = { arg ->
    arg.command(MouseTrackingCommand)
      .demand(1)
  }

  override var handler: (args: Unit) -> Unit = { }

}
