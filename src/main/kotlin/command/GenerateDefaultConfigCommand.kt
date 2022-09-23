package command

import command.base.BaseCommand
import external.node.process
import fs.`T$45`
import res.ResourceLoader

class GenerateDefaultConfigCommand : BaseCommand<Unit>("config-gen") {
    override fun handle(args: Unit) {
        val defaultConfig = ResourceLoader.loadResource("config/default-config.json")
        val generateTarget = process.cwd() + "/config.json"
        fs.writeFileSync(generateTarget, defaultConfig, object : `T$45` {
            override var encoding: String? = "utf8"
        })
        println("Generated default config at $generateTarget")
    }
}
