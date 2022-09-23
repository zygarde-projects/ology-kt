@file:JsModule("@nut-tree/nut-js")
@file:JsNonModule
package external.nuttree

import kotlin.js.Promise

external object screen {
    fun find(image: Promise<NutImage>, params: OptionalSearchParameters?): Promise<Region>
    fun highlight(regionToHighlight: Region): Promise<Region>
}

external object mouse {
    fun move(points: List<Point>): Promise<Unit>
    fun leftClick(): Promise<Unit>
}

external fun imageResource(imagePath: String): Promise<NutImage>
