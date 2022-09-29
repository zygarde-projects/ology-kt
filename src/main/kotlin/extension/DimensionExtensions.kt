package extension

import d2r.constants.DimensionConstants
import external.nuttree.Point
import external.nuttree.Region
import external.wincontrol.Dimensions
import types.PredefinedPoint
import types.PredefinedRegion
import utils.PointTranslator

object DimensionExtensions {
  fun Dimensions.translatePoint(predefinedPoint: PredefinedPoint): Point {
    val windowW = right - left
    val windowH = bottom - top
    return Point(
      x = left + predefinedPoint.x * windowW / DimensionConstants.baseScreenW,
      y = top + predefinedPoint.y * windowH / DimensionConstants.baseScreenH,
    )
  }

  fun Dimensions.translateRegion(region: PredefinedRegion): Region {
    val windowW = right - left
    val windowH = bottom - top
    val regionLeftTopPoint = Point(region.left, region.top)
    val regionRightBottomPoint = Point(region.left + region.width, region.top + region.height)
    val pointTranslator = PointTranslator(DimensionConstants.baseScreenW, DimensionConstants.baseScreenH, windowW, windowH)
    val translatedLeftTop = pointTranslator.translate(regionLeftTopPoint)
    val translatedRightBottom = pointTranslator.translate(regionRightBottomPoint)
    return Region(
      translatedLeftTop.x,
      translatedLeftTop.y,
      translatedRightBottom.x - translatedLeftTop.x,
      translatedRightBottom.y - translatedLeftTop.y
    )
  }

}
