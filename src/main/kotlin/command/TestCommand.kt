package command

import command.base.NoArgCommand
import d2r.D2RController
import d2r.WindowActor
import d2r.action.FindAndEnterTp

object TestCommand : NoArgCommand("test"), WindowActor {
  override suspend fun handle() {
    println("D2R Running: ${D2RController.d2rRunning(true)}")
    try {
      val gameStatus = D2RController.detectGameStatus()
      println("D2R In Game: $gameStatus")
      if (gameStatus?.isInGame() == true) {
        FindAndEnterTp.exec()
      }
    } catch (e: Throwable) {
      println(e)
    }
  }
}
