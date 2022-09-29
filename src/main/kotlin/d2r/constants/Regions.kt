package d2r.constants

import types.PredefinedRegion

object Regions {
  object InGameDetection {
    val menu = PredefinedRegion(520, 1730, 3300 - 520, 2160 - 1730)
    val menuLegacy = PredefinedRegion(482, 1768, 3364 - 482, 2160 - 1768)
  }
}
