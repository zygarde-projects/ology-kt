package external.ws

data class WebSocketServerConfig(val port: Int)

external class WsClient {
    fun send(message: String)
}
