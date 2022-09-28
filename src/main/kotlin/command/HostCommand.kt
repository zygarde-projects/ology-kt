package command

import Buffer
import command.base.NoArgCommand
import conf.HostConfig
import d2r.CommandMessageType
import d2r.D2RController
import extension.CommandMessage
import extension.gameName
import extension.launch
import extension.log
import extension.password
import extension.type
import external.express.express
import external.ws.WebSocket
import external.ws.WebSocketServer
import external.ws.WebSocketServerOptions
import http.IncomingMessage

object HostCommand : NoArgCommand("host") {

    override fun handle() {
        val gameName = "${HostConfig.get("game:prefix")}${HostConfig.get("game:counter")}"
        println("game name: $gameName")

        val wsPort = HostConfig.get("port").toInt()
        val wssOptions = WebSocketServerOptions(port = wsPort)
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

        val httpPort = wsPort + 1
        express()
            .apply {
                get("/ng") { _, res ->
                    val name = HostConfig.get("game:name")
                    val password = HostConfig.get("game:password")
                    log("make new game $name///$password")
                    NgCommand.handle()
                    res.status = 200
                    res.send("$name///$password")
                }
            }
            .listen(port = httpPort) {
                log("http server started localhost:$httpPort")
            }
    }
}
