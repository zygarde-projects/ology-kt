@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external open class MatchRequest(haystack: Image, needle: Image, confidence: Number, searchMultipleScales: Boolean = definedExternally) {
  open var haystack: Image
  open var needle: Image
  open var confidence: Number
  open var searchMultipleScales: Boolean
}
