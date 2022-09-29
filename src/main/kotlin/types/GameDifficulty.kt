package types

import d2r.constants.MouseLocations.Lobby

enum class GameDifficulty(
  val btnPoint: PredefinedPoint,
  val allowConfigValues: List<String>
) {
  NORMAL(
    Lobby.btnGameDifficultyNormal,
    listOf(
      "N",
      "NORMAL",
      "1",
    )
  ),
  NIGHTMARE(
    Lobby.btnGameDifficultyNightmare,
    listOf(
      "NM",
      "NIGHTMARE",
      "2",
    )
  ),
  HELL(
    Lobby.btnGameDifficultyHell,
    listOf(
      "H",
      "HELL",
      "3",
    )
  ),
  //
  ;
}

fun resolveGameDifficulty(v: String): GameDifficulty {
  return GameDifficulty.values()
    .find { it.allowConfigValues.contains(v) }
    ?: GameDifficulty.HELL
}
