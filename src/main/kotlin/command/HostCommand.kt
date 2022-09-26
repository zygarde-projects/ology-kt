package command

import Buffer
import command.base.BaseCommand
import command.base.BaseCommandArgs
import command.base.BaseLoadingConfigFileConfigArgs
import conf.Config
import d2r.CommandMessageType
import d2r.D2RController
import extension.CommandMessage
import extension.gameName
import extension.launch
import extension.log
import extension.password
import extension.type
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
                socket.on("message") { message: Buffer, _ ->
                    val commandMessage: CommandMessage = message.toString()
                    when (commandMessage.type()) {
                        CommandMessageType.CREATE_GAME -> launch { D2RController.makeGame(commandMessage.gameName(), commandMessage.password()) }
                        CommandMessageType.UNKNOWN -> log("UNKNOWN message: $message")
                    }
                }

                println("client connected")
                println("client count: ${wss.clients.size}")
            }
    }
}
