package command

import command.base.NoArgCommand
import conf.ClientConfig
import d2r.CommandMessageType
import d2r.D2RController
import extension.*
import extension.CoroutineExtensions.launch
import external.ws.ReconnectingWebSocket
import external.ws.ReconnectingWebSocketOptions
import external.ws.WSROOT
import external.ws.WebSocket

object ClientCommand : NoArgCommand("client") {

  override suspend fun handle() {
    val host = "ws://${ClientConfig.get("server_ip")}:${ClientConfig.get("server_port")}"
    val ws = ReconnectingWebSocket(
      host,
      emptyArray(),
      ReconnectingWebSocketOptions(
        WSROOT
      )
    )
    ws.addEventListener("open") { _: WebSocket.Event ->
      log("Connected to $host")
    }
    ws.addEventListener("message") { msg: WebSocket.MessageEvent ->
      log("Received: ${msg.data}")
      val command = msg.data.toString()
      when (command.type()) {
        CommandMessageType.GRETTING -> {
          val clientName = ClientConfig.get("name")
          ws.send(CommandMessageType.CLIENT_REG.args(clientName))
        }

        CommandMessageType.NEXT_GAME -> launch {
          D2RController.joinGame(name = command.gameName(), password = command.password())
          ClientConfig.get("bo:enable")
            .takeIf { it.toBoolean() }
            .run { D2RController.startBo() }
        }

        CommandMessageType.DO_ACTION -> launch {
          D2RController.execute(command.action())
        }

        else -> log("unknown command: $command")
      }
    }
  }
}
