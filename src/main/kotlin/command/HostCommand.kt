package command

import external.nconf.nconf
import external.ws.WebSocketServer
import external.ws.WebSocketServerConfig
import external.yargs.Argv
import external.yargs.CommandModule
import external.yargs.Options
import kotlinx.serialization.Serializable

@Serializable
data class HostCommandArgs(
    val config: String
)

const val httpPort = 16667

class HostCommand : CommandModule<dynamic, HostCommandArgs> {
    override var command = "host"

    override var builder: (args: Argv<HostCommandArgs>) -> dynamic = {
        it.options("config", object : Options {
            override var alias = "c"
            override var demandOption = false
        })
    }

    override var handler: (args: HostCommandArgs) -> Unit = {
        println("config path is ${it.config}")
        nconf.file(it.config)
        val gameName = "${nconf.get("prefix")}${nconf.get("index")}"
        println("game name: $gameName")

        val wssConfig = WebSocketServerConfig(port = httpPort)
        val wss = WebSocketServer(wssConfig)
        wss.on("connection") { client ->
            client.send("hello ology client, current game is $gameName")
            println("client connected")
            println("client count: ${wss.clients.size}")
        }
    }
}
