@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external open class AssertClass(screen: ScreenClass) {
  open var screen: Any
  open fun isVisible(needle: FirstArgumentType<Any>, searchRegion: Region = definedExternally, confidence: Number = definedExternally): Promise<Unit>
  open fun notVisible(needle: FirstArgumentType<Any>, searchRegion: Region = definedExternally, confidence: Number = definedExternally): Promise<Unit>
}
