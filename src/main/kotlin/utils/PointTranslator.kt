package utils

import external.nuttree.Point

class PointTranslator(
  fromW: Int,
  fromH: Int,
  toW: Int,
  toH: Int,
) {
  private var wScale = toW.toDouble().div(fromW)
  private var hScale = toH.toDouble().div(fromH)

  fun translate(p: Point): Point {
    return Point((p.x * wScale).toInt(), (p.y * hScale).toInt())
  }
}
