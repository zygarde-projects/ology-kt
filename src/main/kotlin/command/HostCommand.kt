package command

import Buffer
import __dirname
import command.base.NoArgCommand
import conf.ClientConfig
import conf.HostConfig
import d2r.CommandMessageType
import d2r.D2RController
import d2r.constants.MouseLocations
import extension.CollectionExtensions.kt
import extension.CoroutineExtensions.launch
import extension.arg0
import extension.arg1
import extension.log
import extension.type
import external.cors.cors
import external.express.express
import external.ws.WebSocket
import external.ws.WebSocketServer
import external.ws.WebSocketServerOptions
import http.IncomingMessage
import types.ClientState
import types.InGameLifeCycle
import types.OlogyClient
import types.PredefinedPoint

object HostCommand : NoArgCommand("host") {

  var clientIdCounter = 1
  override suspend fun handle() {
    val gameName = "${HostConfig.get("game:prefix")}${HostConfig.get("game:counter")}"
    log("game name: $gameName")
    IPCommand.handle()

    val wsPort = HostConfig.get("port").toInt()
    val wssOptions = WebSocketServerOptions(port = wsPort)
    val wss = WebSocketServer(wssOptions)
    wss
      .on("connection") { socket: OlogyClient, _: IncomingMessage ->
        socket.ologyState = ClientState("${clientIdCounter++}")
        log("client connected: ${wss.clients.size}")
        socket.on("message") { msg: Buffer, _ ->
          val command = msg.toString()
          println("received $command")
          when (command.type()) {
            CommandMessageType.CLIENT_REG -> {
              val clientName = command.arg0()
              socket.ologyState.name = clientName
              socket.ologyState.inGame = command.arg1().toBoolean()
              println("client:${clientName}")
            }

            CommandMessageType.CLIENT_GAME_JOINED -> {
              socket.ologyState.inGame = true
              socket.sendLifeCycleActions(socket.ologyState.name, InGameLifeCycle.POST_JOIN_GAME)
            }

            else -> throw IllegalArgumentException("unknown command type: ${command.type()}")
          }
        }
        socket.send(CommandMessageType.GRETTING.args("hello ology client, current game is $gameName"))

      }

    val httpPort = wsPort + 1
    express()
      .apply {
        use(cors())
        use("/web", express.static("$__dirname/../resources/web"))
        get("/api/ng") { _, res ->
          launch {
            NgCommand.handle()
            val gamePrefix = HostConfig.get("game:prefix")
            val counter = HostConfig.get("game:counter")
            val pwd = HostConfig.get("game:pwd")
            val gamePayload = "$gamePrefix$counter|$pwd"
            wss.clients.kt().forEach { client ->
              client.ologyState.inGame = false
              client.send("${CommandMessageType.NEXT_GAME}|$gamePayload")
            }
            res.status = 200
            res.send(gamePayload)
            Unit
          }
        }

        get("/api/clients") { _, res ->
          res.status = 200
          res.json(
            wss.clients.kt().map { it.ologyState }.sortedBy { it.name }
          )
        }
        get("/api/skillLocation") { _, res ->
          res.status = 200
          res.json(
            PredefinedPoint(
              x = ClientConfig.get("skill_cast_location:x").toIntOrNull() ?: MouseLocations.InGame.charCenter.x,
              y = ClientConfig.get("skill_cast_location:y").toIntOrNull() ?: MouseLocations.InGame.charCenter.y
            ),
          )
        }

        get("/api/clients/:clientId/actions/:action") { req, res ->
          val clientId = "${req.params.clientId}"
          val action = "${req.params.action}"
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.send(CommandMessageType.DO_ACTION.args(action))
          }
          res.status = 200
          res.send("ok")
        }

        get("/api/clients/:clientId/tp") { req, res ->
          val clientId = "${req.params.clientId}"
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.send(CommandMessageType.TP.name)
          }
          res.status = 200
          res.send("ok")
        }
        get("/api/clients/:clientId/skillCast") { req, res ->
          val clientId = "${req.params.clientId}"
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.sendLifeCycleActions(clientWs.ologyState.name, InGameLifeCycle.SKILL_CAST)
          }

          res.status = 200
          res.send("ok")
        }
        get("/api/clients/:clientId/skillCast/location") { req, res ->
          val clientId = "${req.params.clientId}"
          val x = "${req.query.x}"
          val y = "${req.query.y}"
          ClientConfig.set("skill_cast_location:x", x.toIntOrNull() ?: MouseLocations.InGame.charCenter.x)
          ClientConfig.set("skill_cast_location:y", y.toIntOrNull() ?: MouseLocations.InGame.charCenter.y)
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.send(CommandMessageType.SKILL_CAST_LOCATION.args(x, y))
          }
          res.status = 200
          res.send("ok")
        }

        get("/api/clients/:clientId/skillCast/stop") { req, res ->
          val clientId = "${req.params.clientId}"
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.send(CommandMessageType.SKILL_CAST_STOP.name)
          }
          res.status = 200
          res.send("ok")
        }

        get("/api/clients/:clientId/move/:direction") { req, res ->
          val clientId = "${req.params.clientId}"
          val direction = "${req.params.direction}"
          wss.filterAndSend(clientId) { clientWs ->
            clientWs.send(CommandMessageType.MOVE.args(direction))
          }
          res.status = 200
          res.send("ok")
        }
      }
      .listen(port = httpPort) {
        log("http server started localhost:$httpPort")
      }
  }

  private fun WebSocketServer.filterAndSend(clientId: String, block: (wsClient: OlogyClient) -> Unit) {
    clients.kt()
      .filter { clientId == "all" || it.ologyState.id == clientId || it.ologyState.name == clientId }
      .forEach(block)
  }

  private fun WebSocket.sendLifeCycleActions(clientName: Any?, targetLifeCycle: InGameLifeCycle) {
    if (HostConfig.getNullable("client_actions:$clientName:enabled") == "true") {
      D2RController.allActions()
        .filter { it.lifeCycle() == targetLifeCycle }
        .filter { action -> HostConfig.getNullable("client_actions:$clientName:${action.configKey()}") == "true" }
        .map { it.actionName() }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(";")
        ?.let {
          send(CommandMessageType.DO_ACTION.args(it))
        }
    }
  }
}
