package d2r

import extension.await
import extension.toPoint
import external.nuttree.*
import external.wincontrol.WinControl.Window

object MouseController {
    suspend fun clickOnRegionCenter(region: Region) {
        mouse.move(straightTo(centerOf(region))).await()
        mouse.leftClick().await()
    }

    suspend fun clickRelativeXY(p: Point) {
        clickRelativeXY(p.x, p.y)
    }

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
