package d2r

import extension.await
import extension.toPoint
import external.nuttree.Region
import external.nuttree.centerOf
import external.nuttree.mouse
import external.nuttree.straightTo
import external.wincontrol.WinControl.Window

object MouseController {
    suspend fun clickOnRegionCenter(region: Region) {
        mouse.move(straightTo(centerOf(region))).await()
        mouse.leftClick().await()
    }

    /**
     * base screen 3840 x 2160
     */
    suspend fun clickRelativeXY(x: Int, y: Int) {
        Window.getByTitle(gameWindowTitle)?.getDimensions()
            .takeIf { it != null }
            .run {
                val point = this!!.toPoint(x, y, baseScreenW, baseScreenH)
                mouse.move(arrayOf(point)).await()
                mouse.leftClick().await()
            }
    }
}
