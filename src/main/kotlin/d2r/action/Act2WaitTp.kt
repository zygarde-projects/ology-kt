package d2r.action

import d2r.action.base.MoveAction
import d2r.action.base.PostJoinGameAction

object Act2WaitTp : PostJoinGameAction() {

  override suspend fun exec() {
    MoveAction.up(5)
    MoveAction.up(4)
    MoveAction.upRight(5)
    MoveAction.upRight(4)
    MoveAction.downRight(5)
    MoveAction.downRight(4)
    MoveAction.downRight(4)
    MoveAction.upRight(4)
    MoveAction.upRight(4)
    MoveAction.upRight(4)
    MoveAction.up(3)
  }
}
