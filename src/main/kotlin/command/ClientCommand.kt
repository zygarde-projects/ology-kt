package command

import Buffer
import command.base.NoArgCommand
import conf.ClientConfig
import external.ws.WebSocket

object ClientCommand : NoArgCommand("client") {

    override fun handle() {
        val host = "ws://${ClientConfig.get("server_ip")}:${ClientConfig.get("server_port")}"
        val ws = WebSocket(host)
        ws.on("open") { _: WebSocket ->
            println("Connected to $host")
        }
        ws.on("message") { msg: Buffer, _ ->
            println("Received: $msg")
        }
    }
}
