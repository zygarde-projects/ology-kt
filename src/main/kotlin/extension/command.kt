package extension

import d2r.CommandMessageType

typealias CommandMessage = String

fun CommandMessage.type(): CommandMessageType = runCatching {
  split("|")
    .first()
    .let { CommandMessageType.valueOf(it) }
}
  .getOrElse { CommandMessageType.UNKNOWN }

fun CommandMessage.arg0() = split("|")[1]
fun CommandMessage.arg1() = split("|")[2]
fun CommandMessage.gameName() = arg0()
fun CommandMessage.password() = arg1()

fun CommandMessage.action() = arg0()
