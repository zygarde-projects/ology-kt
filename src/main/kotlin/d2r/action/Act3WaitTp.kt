package d2r.action

import d2r.action.base.MoveAction
import d2r.action.base.PostJoinGameAction

object Act3WaitTp : PostJoinGameAction() {

  override suspend fun exec() {
    MoveAction.downRight(2)
    MoveAction.downRight(2)
    MoveAction.upRight(3)
    MoveAction.upRight(3)
    MoveAction.upRight(3)
    MoveAction.upRight(3)
    MoveAction.upRight(3)
    MoveAction.right(2)
    MoveAction.right(2)
    MoveAction.right(2)
    MoveAction.right(2)
    MoveAction.upRight(2)
    MoveAction.upRight(2)
  }
}
