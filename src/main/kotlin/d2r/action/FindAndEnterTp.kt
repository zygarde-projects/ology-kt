package d2r.action

import d2r.MouseController
import d2r.ScreenController
import d2r.action.base.InGameAction
import d2r.constants.ImageMatching

object FindAndEnterTp : InGameAction {
  override suspend fun exec() {
    val tp = ScreenController.oneOfImagesIn(ImageMatching.tpLegacy)?.region
    if (tp != null) {
      MouseController.clickOnRegionCenter(tp)
    }
  }
}
