package command

import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options

class HostCommand : CommandModule<dynamic, dynamic> {
    override var command = "host"

    override var builder: (args: Argv<dynamic>) -> dynamic = {
        it.options("foo", object : Options {
            override var alias = "f"
            override var demandOption = true
        })
    }

    override var handler: (args: dynamic) -> Unit = {
        println("args foo is ${it.foo}")
    }
}
