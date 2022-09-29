package d2r.action

import d2r.action.base.InGameAction
import d2r.action.base.MoveAction

object Act1WaitTp : InGameAction {
  override suspend fun exec() {
    MoveAction.downRight(4)
    MoveAction.downLeft(5)
  }
}
