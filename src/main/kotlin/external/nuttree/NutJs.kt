package external.nuttree

import kotlin.js.Promise

@JsModule("@nut-tree/template-matcher")
@JsNonModule
external fun imageResource(imagePath: String): NutImage

@JsModule("@nut-tree/nut-js")
@JsNonModule
@JsName("screen")
external object Screen {
    fun find(image: NutImage, params: OptionalSearchParameters?): Promise<Region>
    fun highlight(regionToHighlight: Region): Promise<Region>
}
