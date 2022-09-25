@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external open class ClipboardClass(providerRegistry: ProviderRegistry) {
    open var providerRegistry: Any
    open fun copy(text: String): Promise<Unit>
    open fun paste(): Promise<String>
}
