package command

import command.base.BaseCommand
import command.base.YargCommandOption
import d2r.D2RController
import extension.launch

data class JoinGameCommandArg(
    val name: String,
    val pwd: String,
)

object JoinGameCommand : BaseCommand<JoinGameCommandArg>("join") {

    init {
        argOptions.add(YargCommandOption("name", "n", true, "game name"))
        argOptions.add(YargCommandOption("pwd", "p", true, "game pwd"))
    }

    override fun handle(args: JoinGameCommandArg) {
        launch {
            D2RController.joinGame(args.name, args.pwd)
        }
    }
}
