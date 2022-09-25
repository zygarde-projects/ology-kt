@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external open class OptionalSearchParameters(searchRegion: Region? = definedExternally, confidence: Number? = definedExternally, searchMultipleScales: Boolean? = definedExternally, abort: dynamic = definedExternally) {
    open var searchRegion: Region?
    open var confidence: Number?
    open var searchMultipleScales: Boolean?
    open var abort: dynamic
}
