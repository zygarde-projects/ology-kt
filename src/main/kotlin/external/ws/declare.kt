@file:JsModule("ws")
@file:JsNonModule
package external.ws

open external class WebSocketServer(config: WebSocketServerConfig) {
    val clients: List<WsClient>
    fun on(event: String, callback: (client: WsClient) -> Unit)
}

open external class WebSocket(host: String) {
    fun on(event: String, callback: (message: dynamic) -> Unit)
}
