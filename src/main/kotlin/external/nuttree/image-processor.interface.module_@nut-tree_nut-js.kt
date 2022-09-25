@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface ImageProcessor {
    fun colorAt(image: Image, location: Point): Promise<RGBA>
    fun colorAt(image: Image, location: Promise<Point>): Promise<RGBA>
    fun colorAt(image: Promise<Image>, location: Point): Promise<RGBA>
    fun colorAt(image: Promise<Image>, location: Promise<Point>): Promise<RGBA>
}
