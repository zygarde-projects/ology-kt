@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface KeyboardProviderInterface {
    fun setKeyboardDelay(delay: Number)
    fun type(input: String): Promise<Unit>
    fun click(vararg keys: Key): Promise<Unit>
    fun pressKey(vararg keys: Key): Promise<Unit>
    fun releaseKey(vararg keys: Key): Promise<Unit>
}
