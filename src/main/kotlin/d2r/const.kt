package d2r


enum class CommandMessageType {
  // client -> host
  CLIENT_REG,
  CLIENT_GAME_JOINED,

  // host -> client
  NEXT_GAME,
  DO_ACTION,
  TP,
  MOVE,
  SKILL_CAST_LOCATION,
  SKILL_CAST_STOP,

  // other
  GRETTING,
  UNKNOWN,
  //
  ;

  fun args(vararg args: Any): String {
    return listOf(this.name)
      .plus(
        args.map { "$it" }
      )
      .joinToString("|")
  }
}

