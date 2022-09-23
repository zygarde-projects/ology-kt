package command

import external.nconf.nconf
import external.ws.WebSocket
import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options
import kotlinx.serialization.Serializable

@Serializable
data class ClientCommandArgs(
    val config: String
)

class ClientCommand : CommandModule<dynamic, ClientCommandArgs> {
    override var command = "client"

    override var builder: (args: Argv<ClientCommandArgs>) -> dynamic = {
        it.options("config", object : Options {
            override var alias = "c"
            override var demandOption = true
        })
    }

    override var handler: (args: ClientCommandArgs) -> Unit = {
        nconf.file(it.config)
        val host = "ws://${nconf.get("ip")}:$httpPort"
        val ws = WebSocket(host)
        ws.on("open") { println("Connected to $host") }
        ws.on("message") { msg ->
            println("Received: $msg")
        }
    }
}
