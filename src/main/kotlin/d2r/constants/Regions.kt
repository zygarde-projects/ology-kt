package d2r.constants

import types.PredefinedPoint
import types.PredefinedRegion

object Regions {
  object InGameDetection {
    val menu = PredefinedRegion(520, 1730, 3300 - 520, 2160 - 1730)
    val menuLegacy = PredefinedRegion(482, 1768, 3364 - 482, 2160 - 1768)

    val tpLegacy = pointToRegion(
      PredefinedPoint(800, 350),
      PredefinedPoint(2950, 1950),
    )
  }

  object LobbyDetection {
    val gem = pointToRegion(
      PredefinedPoint(1473, 1257),
      PredefinedPoint(2310, 1728),
    )
    val leftBottom = pointToRegion(
      PredefinedPoint(0, 1350),
      PredefinedPoint(450, 2160),
    )
  }

  object Act4Detection {
    val tp = pointToRegion(
      PredefinedPoint(1920, 0),
      PredefinedPoint(3840, 1080),
    )

    val wpMenuTab = pointToRegion(
      PredefinedPoint(0, 0),
      PredefinedPoint(1920, 1080),
    )

    val fireRiver1 = pointToRegion(
      PredefinedPoint(400, 720),
      PredefinedPoint(3140, 2160),
    )

    val fireRiver2 = pointToRegion(
      PredefinedPoint(1920, 960),
      PredefinedPoint(3840, 1920),
    )

    val fireRiver3 = pointToRegion(
      PredefinedPoint(1920, 0),
      PredefinedPoint(3840, 1080),
    )
  }

  private fun pointToRegion(leftTop: PredefinedPoint, rightBottom: PredefinedPoint): PredefinedRegion {
    return PredefinedRegion(leftTop.x, leftTop.y, rightBottom.x - leftTop.x, rightBottom.y - leftTop.y)
  }
}
