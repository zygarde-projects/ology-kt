package d2r.action

import d2r.MouseController
import d2r.ScreenController
import d2r.action.base.NoLifeCycleAction
import d2r.constants.ImageMatching

object FindAndEnterTp : NoLifeCycleAction() {
  override suspend fun exec() {
    val tp = ScreenController.oneOfImagesIn(ImageMatching.tpLegacy)?.region
    if (tp != null) {
      MouseController.clickOnRegionCenter(tp)
    }
  }
}
