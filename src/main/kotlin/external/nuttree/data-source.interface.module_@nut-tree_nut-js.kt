@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface DataSourceInterface<PARAMETER_TYPE, RESULT_TYPE> {
  fun load(parameters: PARAMETER_TYPE): Promise<RESULT_TYPE>
}
