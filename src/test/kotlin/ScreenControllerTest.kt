import d2r.ScreenController
import extension.launch
import kotlin.test.Test

class ScreenControllerTest {
    @Test
    fun checkImageTest() = launch {
        ScreenController.checkImage("act4wp.png")
    }

    @Test
    fun oneOfImagesIn() = launch {
        ScreenController.oneOfImagesIn(
            listOf("fire_river_mark_1.png", "fire_river_mark_2.png", "fire_river_mark_3.png"),
            maxRetry = 0
        )
    }
}
