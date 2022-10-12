package d2r.constants

import d2r.constants.Regions.InGameDetection
import types.MatchingImageRequest

object ImageMatching {
  val DEFAULT = MatchingImageRequest()

  val inGame = mapOf(
    "in-game/in_game_menu_bar.png" to DEFAULT.copy(detectInRegion = InGameDetection.menu),
    "in-game/left_blood_ball.png" to DEFAULT.copy(detectInRegion = InGameDetection.menu),
    "in-game/right_mana_ball.png" to DEFAULT.copy(detectInRegion = InGameDetection.menu),
  )

  val inGameLegacy = mapOf(
    "in-game/legacy-run-bar.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
    "in-game/legacy-status-red.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
    "in-game/legacy-status-gray.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
  )

  val inLobby = mapOf(
    "lobby/lobby_gem.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.gem),
    "lobby/friend-list-btn.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.leftBottom),
    "lobby/left-bottom.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.leftBottom),
  )

  val tpLegacy = mapOf(
    "in-game/tp_legacy_1.png" to DEFAULT.copy(
      detectInRegion = InGameDetection.tpLegacy,
      maxRetry = 2,
      timeoutMs = 1000,
    ),
    "in-game/tp_legacy_2.png" to DEFAULT.copy(
      detectInRegion = InGameDetection.tpLegacy,
      maxRetry = 2,
      timeoutMs = 1000,
    ),
    "in-game/tp_legacy_3.png" to DEFAULT.copy(
      detectInRegion = InGameDetection.tpLegacy,
      maxRetry = 2,
      timeoutMs = 1000,
    ),
    "in-game/tp_legacy_4.png" to DEFAULT.copy(
      detectInRegion = InGameDetection.tpLegacy,
      maxRetry = 2,
      timeoutMs = 1000,
    ),
  )

  val act4tp = mapOf(
    "in-game/act4wp.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.tp,
      maxRetry = 3,
      timeoutMs = 5000,
      baseConfidence = 0.85
    )
  )

  val wpMenuTabAct4 = mapOf(
    "in-game/wp_menu_tab_act4.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.wpMenuTab,
      maxRetry = 3,
      timeoutMs = 5000,
      baseConfidence = 0.82
    )
  )

  val wpInFireRiverAct4 = mapOf(
    "in-game/wp_in_fire_river.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.wpInFireRiver,
      maxRetry = 2,
      baseConfidence = 0.85
    )
  )

  val fireRiver = mapOf(
    "in-game/fire_river_mark_1.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.fireRiver1,
      maxRetry = 1,
      baseConfidence = 0.85
    ),
    "in-game/fire_river_mark_2.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.fireRiver2,
      maxRetry = 1,
      baseConfidence = 0.85
    ),
    "in-game/fire_river_mark_3.png" to DEFAULT.copy(
      detectInRegion = Regions.Act4Detection.fireRiver3,
      maxRetry = 1,
      baseConfidence = 0.85
    )
  )

  val GAME_STATUS_ALL = inGame
    .plus(inGameLegacy)
    .plus(inLobby)

  val IN_GAME_ALL = GAME_STATUS_ALL
    .plus(act4tp)
    .plus(wpMenuTabAct4)
    .plus(wpInFireRiverAct4)
    .plus(fireRiver)
}
