package types

enum class InGameStatus {
  LOBBY,
  IN_GAME,
  IN_GAME_LEGACY,
  //
  ;

  fun isInGame(): Boolean {
    return this == IN_GAME || this == IN_GAME_LEGACY
  }

  fun isInLobby(): Boolean {
    return this == LOBBY
  }
}
