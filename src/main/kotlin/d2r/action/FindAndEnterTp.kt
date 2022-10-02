package d2r.action

import conf.ClientConfig
import d2r.MouseController
import d2r.ScreenController
import d2r.action.base.MoveAction
import d2r.constants.ImageMatching
import external.nuttree.Region
import kotlinx.coroutines.delay

object FindAndEnterTp {
  suspend fun exec(): Boolean {
    val tp = findTp()
    if (tp != null) {
      MouseController.clickOnRegionCenter(tp)
      delay(ClientConfig.get("enter_tp_loading_delay").toLongOrNull() ?: 3000L)
    } else {
      println("FindAndEnterTp: tp not found")
    }
    return tp != null
  }

  private suspend fun findTp(currentRetry: Int = 0, maxRetry: Int = 5): Region? {
    val tp = ScreenController.oneOfImagesIn(ImageMatching.tpLegacy)?.region
    return if (tp == null && currentRetry < maxRetry) {
      println("FindAndEnterTp: tp not found, try move")
      when (currentRetry) {
        0 -> MoveAction.left(2)
        1 -> MoveAction.down(2)
        2 -> MoveAction.up(2)
        3 -> MoveAction.right(2)
      }
      findTp(currentRetry + 1, maxRetry)
    } else {
      tp
    }
  }
}
