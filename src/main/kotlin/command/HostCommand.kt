package command

import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromDynamic

@Serializable
data class HostCommandArgs(
    val foo: String
)

class HostCommand : CommandModule<dynamic, dynamic> {
    override var command = "host"

    override var builder: (args: Argv<dynamic>) -> dynamic = {
        it.options("foo", object : Options {
            override var alias = "f"
            override var demandOption = true
        })
    }

    @ExperimentalSerializationApi
    override var handler: (args: dynamic) -> Unit = {
        val args = Json.decodeFromDynamic<HostCommandArgs>(it)
        println("args foo is ${args.foo}")
    }
}
