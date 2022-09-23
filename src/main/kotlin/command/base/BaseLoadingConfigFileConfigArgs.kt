package command.base

import kotlinx.serialization.Serializable

@Serializable
open class BaseLoadingConfigFileConfigArgs {
    var config: String = "config.json"
}
