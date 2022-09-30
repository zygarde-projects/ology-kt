package command

import command.base.BaseCommand
import command.base.YargCommandOption
import d2r.D2RController

data class JoinGameCommandArg(
  val name: String,
  val pwd: String,
)

object JoinGameCommand : BaseCommand<JoinGameCommandArg>("join") {

  init {
    argOptions.add(YargCommandOption("name", "n", true, "game name"))
    argOptions.add(YargCommandOption("pwd", "p", true, "game pwd"))
  }

  override suspend fun handle(args: JoinGameCommandArg) {
    D2RController.joinGame(args.name, args.pwd)
  }
}
