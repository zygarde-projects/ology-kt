package external.ws

@JsModule("reconnecting-websocket")
@JsNonModule
external class ReconnectingWebSocket(
  address: String,
  listeners: Array<Any?>,
  options: ReconnectingWebSocketOptions,
) : WebSocket {
  fun reconnect()
}

data class ReconnectingWebSocketOptions(
  val WebSocket: Any? = null,
  val startClosed: Boolean = true,
  val debug: Boolean = false,
)
