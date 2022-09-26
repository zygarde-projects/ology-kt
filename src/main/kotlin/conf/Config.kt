package conf

import Provider
import command.GenerateDefaultConfigCommand
import external.nconf.nconf
import external.node.process

enum class ConfigPrefix(val prefix: String) {
    HOST("host"),
    CLIENT("client"),
}

open class Config(val prefix: ConfigPrefix) {
    private val configPath = "${process.cwd()}/config.json"

    init {
        if (!fs.existsSync(configPath)) {
            GenerateDefaultConfigCommand.handle()
        }
    }

    fun get(key: String): String = withConfig {
        "${it.get(prefix.prefix + ":" + key)}"
    }

    fun set(key: String, value: Any) = withConfig {
        it.set(prefix.prefix + ":" + key, value)
    }

    private fun <T> withConfig(block: (config: Provider) -> T): T {
        return block(nconf.file(configPath))
    }
}

object HostConfig : Config(ConfigPrefix.HOST)
object ClientConfig : Config(ConfigPrefix.CLIENT)
