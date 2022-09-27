package extension

import extension.DimensionExtensions.translatePoint
import external.nuttree.Point
import external.wincontrol.Dimensions
import types.PredefinedPoint
import kotlin.test.Test
import kotlin.test.assertEquals

class DimensionsTest {
    @Test
    fun toPointTest() {
        assertEquals(
            Dimensions(left = 0, right = 2560, top = 0, bottom = 1440).translatePoint(PredefinedPoint(100, 100)),
            Point(66, 66)
        )
    }
}
