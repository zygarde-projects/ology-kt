package d2r.action

import d2r.MouseController
import d2r.ScreenController
import d2r.constants.ImageMatching
import d2r.constants.MouseLocations
import external.nuttree.Region

object FindAndEnterTp {
  suspend fun exec(): Boolean {
    val tp = findTp()
    if (tp != null) {
      MouseController.clickOnRegionCenter(tp)
    } else {
      println("FindAndEnterTp: tp not found")
    }
    return tp != null
  }

  private suspend fun findTp(currentRetry: Int = 0, maxRetry: Int = 5): Region? {
    val tp = ScreenController.oneOfImagesIn(ImageMatching.tpLegacy)?.region
    return if (tp == null && currentRetry < maxRetry) {
      println("FindAndEnterTp: tp not found, try move")
      MouseController.clickOn(MouseLocations.InGame.charCenter.randomly(200))
      findTp(currentRetry + 1, maxRetry)
    } else {
      tp
    }
  }
}
