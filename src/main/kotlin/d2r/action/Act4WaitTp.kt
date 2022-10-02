package d2r.action

import d2r.action.base.MoveAction
import d2r.action.base.PostJoinGameAction
import kotlin.random.Random

object Act4WaitTp : PostJoinGameAction() {

  private val routes: Collection<suspend () -> Unit> = listOf(
    {
      MoveAction.upLeft(2)
      MoveAction.upLeft(2)
      MoveAction.up(2)
      MoveAction.upRight(2)
    },
    {
      MoveAction.upRight(3)
      MoveAction.upLeft(3)
    },
  )

  override suspend fun exec() {
    val rand = Random.nextInt(routes.size)
    println("Act1WaitTp using route $rand")
    routes.elementAt(1).invoke()
  }
}
