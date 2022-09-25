package d2r

import extension.await
import external.nuttree.Region
import external.nuttree.centerOf
import external.nuttree.mouse
import external.nuttree.straightTo

object MouseController {
    suspend fun clickOnRegionCenter(region: Region) {
        mouse.move(straightTo(centerOf(region))).await()
        mouse.leftClick().await()
    }
}
