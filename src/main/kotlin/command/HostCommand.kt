package command

import command.base.NoArgCommand
import conf.HostConfig
import d2r.CommandMessageType
import extension.log
import extension.primitiveHashMap
import external.cors.cors
import external.express.express
import external.os.OS
import external.ws.WebSocket
import external.ws.WebSocketServer
import external.ws.WebSocketServerOptions
import http.IncomingMessage
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonObject

object HostCommand : NoArgCommand("host") {

  override fun handle() {
    val gameName = "${HostConfig.get("game:prefix")}${HostConfig.get("game:counter")}"
    log("game name: $gameName")

    val wsPort = HostConfig.get("port").toInt()
    val wssOptions = WebSocketServerOptions(port = wsPort)
    val wss = WebSocketServer(wssOptions)
    wss
      .on("connection") { socket: WebSocket, _: IncomingMessage ->
        socket.send("hello ology client, current game is $gameName")
        log("client connected")
        log("client count: ${wss.clients.size}")
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
        log("http server started ${getHostIp().joinToString()}:$httpPort")
      }
  }

  private fun getHostIp() = primitiveHashMap(OS.networkInterfaces()).values
    .map { net: JsonArray ->
      net.filter { it.jsonObject["family"].toString() == "\"IPv4\"" && it.jsonObject["internal"].toString() == "false" }
    }
    .flatten()
    .map { it.jsonObject["address"].toString().replace("\"", "") }
}
