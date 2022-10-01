package d2r


enum class CommandMessageType {
  // client -> host
  CLIENT_REG,
  CLIENT_GAME_JOINED,
  CLIENT_TP_ENTERED,

  // host -> client
  NEXT_GAME,
  DO_ACTION,
  TP,

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

