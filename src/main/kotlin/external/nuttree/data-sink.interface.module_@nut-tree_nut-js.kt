@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface DataSinkInterface<PARAMETER_TYPE, RETURN_TYPE> {
  fun store(parameters: PARAMETER_TYPE): Promise<RETURN_TYPE>
}
