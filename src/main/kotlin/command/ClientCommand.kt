package command

import external.ws.WebSocket
import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options
import kotlinx.serialization.Serializable

@Serializable
data class ClientCommandArgs(
    val host: String
)

class ClientCommand : CommandModule<dynamic, ClientCommandArgs> {
    override var command = "client"

    override var builder: (args: Argv<ClientCommandArgs>) -> dynamic = {
        it.options("host", object : Options {
            override var alias = "h"
            override var demandOption = true
        })
    }

    override var handler: (args: ClientCommandArgs) -> Unit = {
        val host = "ws://${it.host}:$httpPort"
        val ws = WebSocket(host)
        ws.on("open") { println("Connected to $host") }
        ws.on("message") { msg ->
            println("Received: $msg")
        }
    }
}
