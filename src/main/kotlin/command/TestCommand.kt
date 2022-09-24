package command

import command.base.BaseCommand
import d2r.D2RController

object TestCommand : BaseCommand<Unit>("test") {
    override fun handle(args: Unit) {
        println("D2R Running: ${D2RController.isGameRunning()}")
    }
}
