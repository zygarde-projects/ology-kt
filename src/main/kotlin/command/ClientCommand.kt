package command

import command.base.NoArgCommand
import conf.ClientConfig
import d2r.CommandMessageType
import d2r.D2RController
import d2r.constants.MouseLocations
import extension.*
import extension.CoroutineExtensions.launch
import external.ws.ReconnectingWebSocket
import external.ws.ReconnectingWebSocketOptions
import external.ws.WSROOT
import external.ws.WebSocket
import kotlinx.coroutines.await
import types.MoveDirection
import kotlin.js.Promise

object ClientCommand : NoArgCommand("client") {

  var inGame = false

  override suspend fun handle() {
    refreshGameStatus()
    val host = "ws://${ClientConfig.get("server_ip")}:${ClientConfig.get("server_port")}"
    val ws = ReconnectingWebSocket(
      host,
      emptyArray(),
      ReconnectingWebSocketOptions(
        WebSocket = WSROOT,
        startClosed = true,
        debug = false,
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
    ws.reconnect()
    Promise<Any> { _, _ ->
      // block forever?
    }.await()
  }

  private suspend fun mustInGame(block: suspend () -> Unit) {
    if (!inGame) {
      refreshGameStatus()
      if (!inGame) {
        println("not in game, skip command")
        return
      }
    }
    block()
  }

  private suspend fun refreshGameStatus() {
    inGame = kotlin.runCatching { D2RController.detectGameStatus()?.isInGame() }.getOrNull() == true
  }

  private suspend fun WebSocket.handleCommand(command: String) {
    when (command.type()) {
      CommandMessageType.GRETTING -> {
        val clientName = ClientConfig.get("name")
        send(CommandMessageType.CLIENT_REG.args(clientName, inGame))
      }

      CommandMessageType.NEXT_GAME -> {
        inGame = false
        val joinSuccess = D2RController.joinGame(name = command.gameName(), password = command.password())
        if (joinSuccess) {
          inGame = true
          D2RController.takeIf { ClientConfig.get("bo:enable").toBoolean() }?.startBo()
          send(CommandMessageType.CLIENT_GAME_JOINED.name)
        }
      }

      CommandMessageType.DO_ACTION -> mustInGame {
        for (action in command.actions()) {
          D2RController.execute(action)
        }
      }

      CommandMessageType.SKILL_CAST_STOP -> mustInGame {
        D2RController.stopSkillCast()
      }

      CommandMessageType.TP -> mustInGame {
        D2RController.enterTp()
      }

      CommandMessageType.MOVE -> mustInGame {
        D2RController.move(MoveDirection.valueOf(command.arg0()))
      }

      CommandMessageType.SKILL_CAST_LOCATION -> {
        ClientConfig.set("skill_cast_location:x", command.arg0().toIntOrNull() ?: MouseLocations.InGame.charCenter.x)
        ClientConfig.set("skill_cast_location:y", command.arg1().toIntOrNull() ?: MouseLocations.InGame.charCenter.y)
      }

      else -> log("unknown command: $command")
    }
  }
}
