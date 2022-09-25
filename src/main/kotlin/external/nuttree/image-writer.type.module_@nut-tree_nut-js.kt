@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

external interface ImageWriterParameters {
    var image: Image
    var path: String
}

typealias ImageWriter = DataSinkInterface<ImageWriterParameters, Unit>
