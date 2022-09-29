package d2r


enum class CommandMessageType {
  GRETTING,
  CLIENT_REG,
  NEXT_GAME,
  DO_ACTION,
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

