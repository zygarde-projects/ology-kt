package types

import kotlin.random.Random

data class PredefinedPoint(
  val x: Int,
  val y: Int,
) {
  fun randomly(range: Int): PredefinedPoint {
    return PredefinedPoint(
      x + (range.toDouble() / -2 + Random(range).nextDouble()).toInt(),
      y + (range.toDouble() / -2 + Random(range).nextDouble()).toInt(),
    )

  }
}
