@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface WindowProviderInterface {
  fun getWindows(): Promise<Array<Number>>
  fun getActiveWindow(): Promise<Number>
  fun getWindowTitle(windowHandle: Number): Promise<String>
  fun getWindowRegion(windowHandle: Number): Promise<Region>
}
