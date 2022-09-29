package extension

import d2r.CommandMessageType

typealias CommandMessage = String

fun CommandMessage.type(): CommandMessageType = runCatching {
  split("|")
    .first()
    .let { CommandMessageType.valueOf(it) }
}
  .getOrElse { CommandMessageType.UNKNOWN }

fun CommandMessage.gameName() = split("|")[1]
fun CommandMessage.password() = split("|")[2]

fun CommandMessage.action() = split("|")[1]
