package command

import command.base.NoArgCommand
import external.node.process
import res.ResourceLoader

object GenerateDefaultConfigCommand : NoArgCommand("config-gen") {
  override fun handle() {
    val defaultConfig = ResourceLoader.loadResource("config/default-config.json")
    val generateTarget = process.cwd() + "/config.json"
    fs.writeFileSync(generateTarget, defaultConfig, "utf8")
    println("Generated default config at $generateTarget")
  }
}
