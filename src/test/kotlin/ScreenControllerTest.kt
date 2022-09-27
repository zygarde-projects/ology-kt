import d2r.ScreenController
import extension.launch
import types.MatchingImageRequest
import kotlin.test.Test

class ScreenControllerTest {
    @Test
    fun checkImageTest() = launch {
        ScreenController.matchImage(MatchingImageRequest(image = "in-game/act4wp.png"))
    }

    @Test
    fun oneOfImagesIn() = launch {
        ScreenController.oneOfImagesIn(
            listOf(
                MatchingImageRequest(image = "in-game/fire_river_mark_1.png"),
                MatchingImageRequest(image = "in-game/fire_river_mark_2.png"),
                MatchingImageRequest(image = "in-game/fire_river_mark_3.png"),
            )
        )
    }
}
