package d2r.constants

import types.PredefinedPoint

object MouseLocations {
  object Lobby {
    val makeGameTab = PredefinedPoint(2556, 156)
    val makeGameInputName = PredefinedPoint(2800, 336)

    val joinGameTab = PredefinedPoint(2938, 156)
    val joinGameInputName = PredefinedPoint(2556, 300)
    val joinGameRefresh = PredefinedPoint(3450, 410)

    val btnGameDifficultyNormal = PredefinedPoint(2706, 752)
    val btnGameDifficultyNightmare = PredefinedPoint(2938, 750)
    val btnGameDifficultyHell = PredefinedPoint(3186, 752)
  }

  object InGame {
    val btnExitGame = PredefinedPoint(1920, 950)
  }
}
