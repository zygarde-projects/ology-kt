package extension

import external.nuttree.Point
import external.wincontrol.Dimensions

fun Dimensions.toPoint(x: Int, y: Int, baseScreenW: Int, baseScreenH: Int): Point {
    val windowW = right - left
    val windowH = bottom - top
    return Point(
        x = x * windowW / baseScreenW,
        y = y * windowH / baseScreenH
    )
}
