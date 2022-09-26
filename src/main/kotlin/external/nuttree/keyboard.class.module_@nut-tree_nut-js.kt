@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface `T$9` {
    var autoDelayMs: Number
}

external open class KeyboardClass(providerRegistry: ProviderRegistry) {
    open var providerRegistry: Any
    open var config: `T$9`
    open fun type(vararg input: String): Promise<KeyboardClass>
    open fun type(vararg input: KeyBtn): Promise<KeyboardClass>
    open fun pressKey(vararg keys: KeyBtn): Promise<KeyboardClass>
    open fun releaseKey(vararg keys: KeyBtn): Promise<KeyboardClass>
}
