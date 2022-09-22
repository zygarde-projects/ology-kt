package command

import external.ws.WebSocketServer
import external.ws.WebSocketServerConfig
import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options
import kotlinx.serialization.Serializable

@Serializable
data class HostCommandArgs(
    val foo: String
)

const val httpPort = 16667

class HostCommand : CommandModule<dynamic, HostCommandArgs> {
    override var command = "host"

    override var builder: (args: Argv<HostCommandArgs>) -> dynamic = {
        it.options("foo", object : Options {
            override var alias = "f"
            override var demandOption = true
        })
    }

    override var handler: (args: HostCommandArgs) -> Unit = {
        println("args foo is ${it.foo}")

        val wssConfig = WebSocketServerConfig(port = httpPort)
        val wss = WebSocketServer(wssConfig)
        wss.on("connection") { client ->
            client.send("hello ology client")
            println("client connected")
            println("client count: ${wss.clients.size}")
        }
    }
}
