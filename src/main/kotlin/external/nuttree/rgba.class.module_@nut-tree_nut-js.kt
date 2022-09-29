@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external open class RGBA(R: Number, G: Number, B: Number, A: Number) {
  open var R: Number
  open var G: Number
  open var B: Number
  open var A: Number
  override fun toString(): String
  open fun toHex(): String
}
