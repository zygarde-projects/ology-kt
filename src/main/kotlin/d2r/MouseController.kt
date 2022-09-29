package d2r

import extension.await
import external.nuttree.*
import types.PredefinedPoint

object MouseController : WindowActor {
    suspend fun clickOnRegionCenter(region: Region) {
        mouse.move(straightTo(centerOf(region))).await()
        mouse.leftClick().await()
    }

    suspend fun clickOn(predefinedPoint: PredefinedPoint) = withTranslatedPoint(predefinedPoint) {
        clickOn(it)
    }

    suspend fun clickOn(point: Point) {
        mouse.move(arrayOf(point)).await()
        mouse.leftClick().await()
    }

    suspend fun rightClick() = mouse.rightClick().await()
}
