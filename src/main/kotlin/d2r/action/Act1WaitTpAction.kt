package d2r.action

import d2r.action.base.MoveAction

object Act1WaitTpAction {
  suspend fun exec() {
    MoveAction.downRight(4)
    MoveAction.downLeft(5)
  }
}
