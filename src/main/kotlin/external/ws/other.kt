package external.ws

data class WebSocketServerOptions(val port: Int)

@JsModule("ws")
@JsNonModule
external object WSROOT
