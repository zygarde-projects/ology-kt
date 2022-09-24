package command

import command.base.BaseCommand
import external.node.process
import res.ResourceLoader

object GenerateDefaultConfigCommand : BaseCommand<Unit>("config-gen") {
    override fun handle(args: Unit) {
        val defaultConfig = ResourceLoader.loadResource("config/default-config.json")
        val generateTarget = process.cwd() + "/config.json"
        fs.writeFileSync(generateTarget, defaultConfig, "utf8")
        println("Generated default config at $generateTarget")
    }
}
