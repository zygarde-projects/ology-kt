package d2r.action

import d2r.MouseController
import d2r.action.base.PostJoinGameAction
import types.PredefinedPoint

object Act5WaitTp : PostJoinGameAction() {

  private val points: Collection<PredefinedPoint> = listOf(
    PredefinedPoint(x = 1494, y = 759),
    PredefinedPoint(x = 2346, y = 1305),
    PredefinedPoint(x = 2172, y = 675),
    PredefinedPoint(x = 2409, y = 747),
    PredefinedPoint(x = 1983, y = 1293),
    PredefinedPoint(x = 2448, y = 759),
    PredefinedPoint(x = 2757, y = 969),
    PredefinedPoint(x = 1341, y = 1065),
    PredefinedPoint(x = 1680, y = 1194),
  )

  override suspend fun exec() {
    val point = points.random()
    MouseController.clickOn(point)
    MouseController.clickOn(point)
  }
}
