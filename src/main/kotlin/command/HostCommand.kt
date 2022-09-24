package command

import command.base.BaseCommand
import command.base.BaseCommandArgs
import command.base.BaseLoadingConfigFileConfigArgs
import conf.Config
import external.ws.WebSocketServer
import external.ws.WebSocketServerConfig

object HostCommand : BaseCommand<BaseLoadingConfigFileConfigArgs>("host") {

    init {
        argOptions.add(BaseCommandArgs.CONFIG)
    }

    override fun handle(args: BaseLoadingConfigFileConfigArgs) {
        val config = Config(args.config, "host")
        val gameName = "${config.get("game:prefix")}${config.get("game:counter")}"
        println("game name: $gameName")

        val wssConfig = WebSocketServerConfig(port = config.get("port").toInt())
        val wss = WebSocketServer(wssConfig)
        wss.on("connection") { client ->
            client.send("hello ology client, current game is $gameName")
            println("client connected")
            println("client count: ${wss.clients.size}")
        }
    }
}
