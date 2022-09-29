package d2r.constants

import types.PredefinedPoint

object MouseLocations {
  object Lobby {

    val makeGameTab = PredefinedPoint(2556, 156)
    val makeGameInputName = PredefinedPoint(2800, 336)

    val moveWhenInFireRiver = PredefinedPoint(2000, 1050)
    val fireRiver = PredefinedPoint(666, 777)

    val joinGameTab = PredefinedPoint(2938, 156)
    val joinGameInputName = PredefinedPoint(2556, 300)
    val joinGameRefresh = PredefinedPoint(3450, 410)

    val btnGameDifficultyNormal = PredefinedPoint(2706, 752)
    val btnGameDifficultyNightmare = PredefinedPoint(2938, 750)
    val btnGameDifficultyHell = PredefinedPoint(3186, 752)
  }

  object InGame {
    val btnExitGame = PredefinedPoint(1920, 950)

    val charCenter = PredefinedPoint(1920, 1080)
    val moveT = PredefinedPoint(1920, 100)
    val moveB = PredefinedPoint(1920, 1800)
    val moveL = PredefinedPoint(400, 1000)
    val moveR = PredefinedPoint(3440, 1000)
    val moveLT = PredefinedPoint(400, 100)
    val moveRT = PredefinedPoint(3440, 100)
    val moveLB = PredefinedPoint(400, 1800)
    val moveRB = PredefinedPoint(3440, 1800)
  }
}
