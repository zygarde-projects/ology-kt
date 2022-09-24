package d2r

import external.wincontrol.Window

object D2RController {
    private val gameWindowTitle = "Diablo II: Resurrected"

    fun isGameRunning(switchToForegroundWhenRunning: Boolean = false): Boolean {
        val d2r = Window.getByTitle(gameWindowTitle)
        if (switchToForegroundWhenRunning && d2r != null) {
            d2r.setForeground()
        }
        return d2r != null
    }
}
