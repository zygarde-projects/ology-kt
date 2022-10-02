package types

import kotlin.random.Random

data class PredefinedPoint(
  val x: Int,
  val y: Int,
) {
  fun randomly(range: Int): PredefinedPoint {
    return PredefinedPoint(
      x + (range.toDouble() / -2 + range * Random.nextDouble()).toInt(),
      y + (range.toDouble() / -2 + range * Random.nextDouble()).toInt(),
    )
  }
}
