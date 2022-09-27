import d2r.ScreenController
import extension.launch
import types.MatchingImageRequest
import kotlin.test.Test

class ScreenControllerTest {
    @Test
    fun checkImageTest() = launch {
        ScreenController.matchImage("in-game/act4wp.png", MatchingImageRequest())
    }

    @Test
    fun oneOfImagesIn() = launch {
        ScreenController.oneOfImagesIn(
            listOf(
                "in-game/fire_river_mark_1.png",
                "in-game/fire_river_mark_2.png",
                "in-game/fire_river_mark_3.png",
            )
        )
    }
}
