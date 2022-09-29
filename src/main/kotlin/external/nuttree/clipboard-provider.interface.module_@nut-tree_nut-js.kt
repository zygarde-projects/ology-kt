@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface ClipboardProviderInterface {
  fun hasText(): Promise<Boolean>
  fun clear(): Promise<Boolean>
  fun copy(text: String): Promise<Unit>
  fun paste(): Promise<String>
}
