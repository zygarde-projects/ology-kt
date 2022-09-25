package command

import command.base.BaseCommand
import command.base.BaseCommandArgs
import command.base.BaseLoadingConfigFileConfigArgs
import conf.Config
import external.ws.WebSocket


object ClientCommand : BaseCommand<BaseLoadingConfigFileConfigArgs>("client") {

    init {
        argOptions.add(BaseCommandArgs.CONFIG)
    }

    override fun handle(args: BaseLoadingConfigFileConfigArgs) {
        val config = Config(args.config, "client")
        val host = "ws://${config.get("server_ip")}:${config.get("server_port")}"
        val ws = WebSocket(host)
        ws.on("open") { _ ->
            println("Connected to $host")
        }
        ws.on("message") { msg ->
            println("Received: $msg")
        }
    }
}
