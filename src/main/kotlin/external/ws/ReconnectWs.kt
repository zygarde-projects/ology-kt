package external.ws

@JsModule("reconnecting-websocket")
@JsNonModule
external class ReconnectingWebSocket(
  address: String,
  listeners: Array<Any?>,
  options: ReconnectingWebSocketOptions,
) : WebSocket

data class ReconnectingWebSocketOptions(
  val WebSocket: Any? = null
)
