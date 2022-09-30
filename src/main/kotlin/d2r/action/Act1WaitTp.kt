package d2r.action

import d2r.action.base.InGameAction
import d2r.action.base.MoveAction

object Act1WaitTp : InGameAction {

  private val routes: Collection<suspend () -> Unit> = listOf(
    {
      MoveAction.left(5)
      MoveAction.down(4)
      MoveAction.downRight(2)
    },
    {
      MoveAction.downLeft(2)
      MoveAction.downLeft(2)
      MoveAction.down(4)
    },
    {
      MoveAction.upLeft(2)
      MoveAction.down(2)
      MoveAction.down(2)
      MoveAction.down(2)
      MoveAction.down(2)
    },
    {
      MoveAction.right(2)
      MoveAction.down(2)
      MoveAction.down(4)
      MoveAction.left(2)
    },
    {
      MoveAction.upRight(2)
      MoveAction.down(4)
      MoveAction.down(4)
      MoveAction.left(3)
    },
    {
      MoveAction.down(2)
      MoveAction.left(2)
      MoveAction.down(3)
      MoveAction.down(2)
    },
  )

  override suspend fun exec() {
    routes.random().invoke()
  }
}
