package command

import command.base.NoArgCommand
import conf.HostConfig
import d2r.D2RController
import extension.launch
import types.resolveGameDifficulty

object NgCommand : NoArgCommand("ng") {
  override fun handle() {
    val gamePrefix = HostConfig.get("game:prefix")
    val pwd = HostConfig.get("game:pwd")
    val counter = (HostConfig.get("game:counter").toIntOrNull() ?: 0) + 1
    val difficulty = resolveGameDifficulty(HostConfig.get("game:difficulty"))
    launch {
      D2RController.makeGame("$gamePrefix$counter", pwd, difficulty)
      HostConfig.set("game:counter", counter)
    }
  }
}
