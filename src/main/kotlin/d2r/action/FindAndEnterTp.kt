package d2r.action

import d2r.MouseController
import d2r.ScreenController
import d2r.constants.ImageMatching

object FindAndEnterTp {
  suspend fun exec(): Boolean {
    val tp = ScreenController.oneOfImagesIn(ImageMatching.tpLegacy)?.region
    if (tp != null) {
      MouseController.clickOnRegionCenter(tp)
    }
    return tp != null
  }
}
