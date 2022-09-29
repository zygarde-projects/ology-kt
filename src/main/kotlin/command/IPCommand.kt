package command

import command.base.NoArgCommand
import extension.log
import external.os.OS

object IPCommand : NoArgCommand("ip") {
  override fun handle() {
    JSON.stringify(OS.networkInterfaces()) { key, value ->
      if (key == "address" && value.toString().startsWith("192")) {
        log("IP: $value")
      }
      value
    }
  }
}
