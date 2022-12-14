package d2r.action.base

import d2r.WindowActor
import d2r.constants.MouseLocations.InGame.charCenter
import d2r.constants.MouseLocations.InGame.moveB
import d2r.constants.MouseLocations.InGame.moveL
import d2r.constants.MouseLocations.InGame.moveLB
import d2r.constants.MouseLocations.InGame.moveLT
import d2r.constants.MouseLocations.InGame.moveR
import d2r.constants.MouseLocations.InGame.moveRB
import d2r.constants.MouseLocations.InGame.moveRT
import d2r.constants.MouseLocations.InGame.moveT
import extension.DimensionExtensions.translatePoint
import external.nuttree.mouse
import external.nuttree.sleep
import kotlinx.coroutines.await
import types.MoveDirection
import types.PredefinedPoint
import kotlin.math.min

object MoveAction : WindowActor {

  const val maxDistance = 5

  suspend fun move(direction: MoveDirection, distance: Int) {
    when (direction) {
      MoveDirection.UP -> up(distance)
      MoveDirection.DOWN -> down(distance)
      MoveDirection.LEFT -> left(distance)
      MoveDirection.RIGHT -> right(distance)
      MoveDirection.UP_LEFT -> upLeft(distance)
      MoveDirection.UP_RIGHT -> upRight(distance)
      MoveDirection.DOWN_LEFT -> downLeft(distance)
      MoveDirection.DOWN_RIGHT -> downRight(distance)
    }
  }

  suspend fun up(distance: Int) = moveFromTo(charCenter, moveT, distance)
  suspend fun down(distance: Int) = moveFromTo(charCenter, moveB, distance)
  suspend fun right(distance: Int) = moveFromTo(charCenter, moveR, distance)
  suspend fun left(distance: Int) = moveFromTo(charCenter, moveL, distance)

  suspend fun upLeft(distance: Int) = moveFromTo(charCenter, moveLT, distance)
  suspend fun upRight(distance: Int) = moveFromTo(charCenter, moveRT, distance)
  suspend fun downLeft(distance: Int) = moveFromTo(charCenter, moveLB, distance)
  suspend fun downRight(distance: Int) = moveFromTo(charCenter, moveRB, distance)

  private suspend fun moveFromTo(
    p1: PredefinedPoint,
    p2: PredefinedPoint,
    distance: Int
  ) = withWindowDimension { d ->
    val actualDistance = min(distance, maxDistance)
    val targetPoint = distanceOf(p1, p2, actualDistance).randomly(50)
    val targetPointTranslated = d.translatePoint(targetPoint)
    mouse.move(arrayOf(targetPointTranslated))
      .then { mouse.leftClick() }
      .then { sleep(actualDistance * 350) }
      .await()
  }

  private fun distanceOf(p1: PredefinedPoint, p2: PredefinedPoint, distance: Int): PredefinedPoint {
    val xDiff = p2.x - p1.x
    val yDiff = p2.y - p1.y

    return PredefinedPoint(
      p1.x + (xDiff * distance / maxDistance.toDouble()).toInt(),
      p1.y + (yDiff * distance / maxDistance.toDouble()).toInt(),
    )
  }

}
