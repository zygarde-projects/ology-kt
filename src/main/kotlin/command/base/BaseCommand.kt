package command.base

import extension.launch
import external.yargs.Argv
import external.yargs.CommandModule

abstract class BaseCommand<ARGS>(override var command: String) : CommandModule<dynamic, ARGS> {

  protected val argOptions: MutableList<YargCommandOption> = mutableListOf()

  override var builder: (args: Argv<ARGS>) -> dynamic = { arg ->
    for (o in argOptions) {
      arg.options(o.key, o)
    }
  }

  override var handler: (args: ARGS) -> Unit = { args ->
    launch { handle(args) }
  }

  abstract suspend fun handle(args: ARGS)

}
