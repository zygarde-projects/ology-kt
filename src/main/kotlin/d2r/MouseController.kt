package d2r

import extension.await
import external.nuttree.Point
import external.nuttree.Region
import external.nuttree.mouse

class MouseController {
    suspend fun clickOnRegionCenter(region: Region) {
        val point = Point(left = region.width / 2, top = region.height / 2)
        mouse.move(listOf(point)).await()
        mouse.leftClick().await()
    }
}
