@file:JsModule("@nut-tree/nut-js")
@file:JsNonModule
package external.nuttree

import kotlin.js.Promise

@JsName("screen")
external object Screen {
    fun find(image: Promise<NutImage>, params: OptionalSearchParameters?): Promise<Region>
    fun highlight(regionToHighlight: Region): Promise<Region>
}

external fun imageResource(imagePath: String): Promise<NutImage>
