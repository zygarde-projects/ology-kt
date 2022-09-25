package command

import command.base.BaseCommand
import command.base.BaseCommandArgs
import command.base.BaseLoadingConfigFileConfigArgs
import conf.Config
import external.ws.WebSocket
import external.ws.WebSocketServer
import external.ws.WebSocketServerOptions
import http.IncomingMessage

object HostCommand : BaseCommand<BaseLoadingConfigFileConfigArgs>("host") {

    init {
        argOptions.add(BaseCommandArgs.CONFIG)
    }

    override fun handle(args: BaseLoadingConfigFileConfigArgs) {
        val config = Config(args.config, "host")
        val gameName = "${config.get("game:prefix")}${config.get("game:counter")}"
        println("game name: $gameName")

        val wssOptions = WebSocketServerOptions(port = config.get("port").toInt())
        val wss = WebSocketServer(wssOptions)
        wss
            .on("connection") { socket: WebSocket, _: IncomingMessage ->
                socket.send("hello ology client, current game is $gameName")
                socket.on("message") { msg ->
                    println("incoming message: $msg")
                }

                println("client connected")
                println("client count: ${wss.clients.size}")
            }
    }
}
