package command

import Buffer
import command.base.NoArgCommand
import conf.HostConfig
import d2r.CommandMessageType
import d2r.D2RController
import extension.*
import external.ws.WebSocket
import external.ws.WebSocketServer
import external.ws.WebSocketServerOptions
import http.IncomingMessage

object HostCommand : NoArgCommand("host") {

    override fun handle() {
        val gameName = "${HostConfig.get("game:prefix")}${HostConfig.get("game:counter")}"
        println("game name: $gameName")

        val wssOptions = WebSocketServerOptions(port = HostConfig.get("port").toInt())
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
