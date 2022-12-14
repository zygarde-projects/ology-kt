package conf

import __dirname
import command.GenerateDefaultConfigCommand
import extension.CoroutineExtensions.launch
import external.nconf.Provider
import external.nconf.nconf
import external.node.process
import external.nuttree.KeyBtn
import external.nuttree.getKey

enum class ConfigPrefix(val prefix: String) {
  SYSTEM("system"),
  HOST("host"),
  CLIENT("client"),
  SKILL("client:skill_keys"),
}

open class Config(val prefix: ConfigPrefix) {
  private val defaultConfigPath = "$__dirname/../resources/config/default-config.json"
  private val configPath = "${process.cwd()}/config.json"

  init {
    launch {
      if (!fs.existsSync(configPath)) {
        GenerateDefaultConfigCommand.handle()
      }
    }
  }

  fun get(key: String): String = withConfig { config ->
    val configKey = prefix.prefix + ":" + key
    var v = config.get(configKey)
    if (v == null) {
      v = nconf.file(defaultConfigPath).get(configKey)?.also { set(key, "$it") }
    }
    "$v"
  }

  fun getNullable(key: String): String? = kotlin.runCatching { get(key) }.getOrNull()

  fun set(key: String, value: Any) = withConfig { config ->
    config.set(prefix.prefix + ":" + key, value)
    config.save("")
  }

  private fun <T> withConfig(block: (config: Provider) -> T): T {
    return block(nconf.file(configPath))
  }
}

object SystemConfig : Config(ConfigPrefix.SYSTEM)
object HostConfig : Config(ConfigPrefix.HOST)
object ClientConfig : Config(ConfigPrefix.CLIENT)

object SkillConfig : Config(ConfigPrefix.SKILL) {
  fun getKeyBtn(key: String): KeyBtn {
    return getKey(get(key))
  }
}
