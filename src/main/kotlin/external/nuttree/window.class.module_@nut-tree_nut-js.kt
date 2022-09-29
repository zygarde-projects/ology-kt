@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external open class Window(providerRegistry: ProviderRegistry, windowHandle: Number) {
  open var providerRegistry: Any
  open var windowHandle: Any
}
