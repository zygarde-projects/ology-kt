package command

import command.base.NoArgCommand
import conf.HostConfig
import d2r.CommandMessageType
import extension.log
import external.cors.cors
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
                println("client connected")
                println("client count: ${wss.clients.size}")
            }

        val httpPort = wsPort + 1
        express()
            .apply {
                use(cors())
                get("/ng") { _, res ->
                    NgCommand.handle()
                    val gamePrefix = HostConfig.get("game:prefix")
                    val counter = HostConfig.get("game:counter")
                    val pwd = HostConfig.get("game:pwd")
                    val gamePayload = "$gamePrefix$counter|$pwd"
                    wss.clients.forEach({ client, _, _ ->
                        client.send("${CommandMessageType.NEXT_GAME}|$gamePayload")
                    })
                    res.status = 200
                    res.send(gamePayload)
                }
            }
            .listen(port = httpPort) {
                log("http server started localhost:$httpPort")
            }
    }
}
