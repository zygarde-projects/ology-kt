package conf

import Provider
import external.nconf.nconf

open class Config(path: String, val prefix: String) {
    init {
        println("loading path from $path")
    }

    val config: Provider = nconf.file(path)

    fun get(key: String): String {
        return "${config.get(prefix + ":" + key)}"
    }
}
