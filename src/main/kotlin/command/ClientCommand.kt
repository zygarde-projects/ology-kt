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
    ws.addEventListener("error") { e: WebSocket.ErrorEvent ->
      log("WS Error $e")
    }
    ws.addEventListener("message") { msg: WebSocket.MessageEvent ->
      log("Received: ${msg.data}")
      launch {
        ws.handleCommand(msg.data.toString())
      }
    }
  }

  private suspend fun WebSocket.handleCommand(command: String) {
    when (command.type()) {
      CommandMessageType.GRETTING -> {
        val clientName = ClientConfig.get("name")
        send(CommandMessageType.CLIENT_REG.args(clientName))
      }

      CommandMessageType.NEXT_GAME -> {
        val joinSuccess = D2RController.joinGame(name = command.gameName(), password = command.password())
        if (joinSuccess) {
          D2RController.takeIf { ClientConfig.get("bo:enable").toBoolean() }?.startBo()
          send(CommandMessageType.CLIENT_GAME_JOINED.name)
        }
      }

      CommandMessageType.DO_ACTION -> {
        for (action in command.actions()) {
          D2RController.execute(action)
        }
      }

      CommandMessageType.TP -> {
        val enteredTp = D2RController.enterTp()
        if (enteredTp) {
          send(CommandMessageType.CLIENT_TP_ENTERED.name)
        }
      }

      else -> log("unknown command: $command")
    }
  }
}
