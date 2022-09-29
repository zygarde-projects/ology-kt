@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external open class MatchResult(confidence: Number, location: Region, error: Error? = definedExternally) {
  open var confidence: Number
  open var location: Region
  open var error: Error?
}
