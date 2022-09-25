package extension

import d2r.baseScreenH
import d2r.baseScreenW
import external.nuttree.Point
import external.wincontrol.Dimensions
import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionsTest {
    @Test
    fun toPointTest() {
        assertEquals(
            Dimensions(left = 0, right = 2560, top = 0, bottom = 1440).toPoint(100, 100, baseScreenW, baseScreenH),
            Point(66, 66)
        )
    }
}
