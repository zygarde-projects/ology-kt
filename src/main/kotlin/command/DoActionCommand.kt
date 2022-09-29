package command

import command.base.BaseCommand
import command.base.YargCommandOption
import d2r.D2RController

data class DoActionCommandArg(
  val action: String,
)

object DoActionCommand : BaseCommand<DoActionCommandArg>("action") {

  init {
    argOptions.add(
      YargCommandOption(
        "action",
        "a",
        true,
        "action to run, ${D2RController.allActionNames().joinToString("|")}"
      )
    )
  }

  override fun handle(args: DoActionCommandArg) {
    D2RController.d2rRunning(true)
    D2RController.execute(args.action)
  }
}
