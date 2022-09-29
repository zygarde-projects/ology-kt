package command

import Buffer
import command.base.NoArgCommand
import conf.ClientConfig
import d2r.CommandMessageType
import d2r.D2RController
import extension.*
import external.ws.WebSocket

object ClientCommand : NoArgCommand("client") {

  override fun handle() {
    val host = "ws://${ClientConfig.get("server_ip")}:${ClientConfig.get("server_port")}"
    val ws = WebSocket(host)
    ws.on("open") { _: WebSocket ->
      log("Connected to $host")
    }
    ws.on("message") { msg: Buffer, _ ->
      log("Received: $msg")
      val command = msg.toString()
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

        CommandMessageType.DO_ACTION -> {
          D2RController.execute(command.action())
        }

        else -> log("unknown command: $command")
      }
    }
  }
}
