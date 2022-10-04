package types

import external.ws.WebSocket
import kotlin.js.Date

abstract class OlogyClient : WebSocket() {
  lateinit var ologyState: ClientState
}

data class ClientState(
  val id: String,
  var name: String? = null,
  val connectAt: Number = Date().getTime(),
  var inGame: Boolean = false,
)
