package command.base

import external.yargs.Argv
import external.yargs.CommandModule

abstract class BaseCommand<ARGS>(override var command: String) : CommandModule<dynamic, ARGS> {

    protected val argOptions: MutableList<YargCommandOption> = mutableListOf()

    override var builder: (args: Argv<ARGS>) -> dynamic = { arg ->
        for (o in argOptions) {
            arg.options(o.key, o)
        }
    }

    override var handler: (args: ARGS) -> Unit = ::handle

    protected abstract fun handle(args: ARGS)

}
