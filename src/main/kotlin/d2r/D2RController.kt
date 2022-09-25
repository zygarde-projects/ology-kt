package d2r

import external.nuttree.Key
import external.nuttree.keyboard
import external.wincontrol.WinControl.Window
import kotlinx.coroutines.await
import kotlinx.coroutines.delay

object D2RController {
    fun isGameRunning(switchToForegroundWhenRunning: Boolean = false): Boolean {
        val d2r = Window.getByTitle(gameWindowTitle)
        if (switchToForegroundWhenRunning && d2r != null) {
            d2r.setForeground()
        }
        return d2r != null
    }

    suspend fun isInGame() = ScreenController.oneOfImagesIn(
        listOf(
            "in_game_menu_bar.png",
            "left_blood_ball.png",
            "right_mana_ball.png"
        )
    ) != null

    suspend fun exitGame() {
        delay(100)
        keyboard.pressKey(Key.Escape).await()
        keyboard.releaseKey(Key.Escape).await()
        delay(100)
        MouseController.clickRelativeXY(x = exitGameX, y = exitGameY)
    }
}
