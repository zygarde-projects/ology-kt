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
    "in-game/in_game_menu_bar_legacy.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
    "in-game/left_blood_ball_legacy.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
    "in-game/right_mana_ball_legacy.png" to DEFAULT.copy(detectInRegion = InGameDetection.menuLegacy),
  )

  val inLobby = mapOf(
    "lobby/lobby_gem.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.gem),
    "lobby/friend-list-btn.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.leftBottom),
    "lobby/left-bottom.png" to DEFAULT.copy(detectInRegion = Regions.LobbyDetection.leftBottom),
  )

  val IN_GAME_ALL = inGame
    .plus(inGameLegacy)
    .plus(inLobby)
}
