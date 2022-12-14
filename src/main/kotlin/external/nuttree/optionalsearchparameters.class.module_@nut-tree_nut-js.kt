@file:Suppress(
  "INTERFACE_WITH_SUPERCLASS",
  "OVERRIDING_FINAL_MEMBER",
  "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
  "CONFLICTING_OVERLOADS"
)

package external.nuttree

import external.node.AbortSignal

data class OptionalSearchParameters(
  val searchRegion: Region? = null,
  val confidence: Number? = null,
  val searchMultipleScales: Boolean? = null,
  val abortSignal: AbortSignal? = null,
)
