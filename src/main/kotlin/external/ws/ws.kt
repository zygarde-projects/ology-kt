@file:JsModule("ws")
@file:JsNonModule

package external.ws

import Buffer
import http.Agent
import http.ClientRequest
import http.ClientRequestArgs
import http.IncomingMessage
import stream.internal.Duplex
import stream.internal.DuplexOptions
import tls.SecureContextOptions
import tsstdlib.Set
import url.URL
import zlib.ZlibOptions

external class WsClient {
  fun send(message: String)
}

external interface `T$13` {
  var mask: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var binary: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var compress: Boolean?
    get() = definedExternally
    set(value) = definedExternally
  var fin: Boolean?
    get() = definedExternally
    set(value) = definedExternally
}

external class WebSocketServer(options: WebSocketServerOptions) : WebSocket.Server<WebSocket>

open external class WebSocket {

  constructor(address: Nothing?)
  constructor(address: String, options: ClientOptions = definedExternally)
  constructor(address: String)
  constructor(address: String, options: ClientRequestArgs = definedExternally)
  constructor(address: URL, options: ClientOptions = definedExternally)
  constructor(address: URL)
  constructor(address: URL, options: ClientRequestArgs = definedExternally)
  constructor(address: String, protocols: String = definedExternally, options: ClientOptions = definedExternally)
  constructor(address: String, protocols: String = definedExternally)
  constructor(address: String, protocols: String = definedExternally, options: ClientRequestArgs = definedExternally)
  constructor(address: String, protocols: Array<String> = definedExternally, options: ClientOptions = definedExternally)
  constructor(address: String, protocols: Array<String> = definedExternally)
  constructor(address: String, protocols: Array<String> = definedExternally, options: ClientRequestArgs = definedExternally)
  constructor(address: URL, protocols: String = definedExternally, options: ClientOptions = definedExternally)
  constructor(address: URL, protocols: String = definedExternally)
  constructor(address: URL, protocols: String = definedExternally, options: ClientRequestArgs = definedExternally)
  constructor(address: URL, protocols: Array<String> = definedExternally, options: ClientOptions = definedExternally)
  constructor(address: URL, protocols: Array<String> = definedExternally)
  constructor(address: URL, protocols: Array<String> = definedExternally, options: ClientRequestArgs = definedExternally)

  open var binaryType: String /* "nodebuffer" | "arraybuffer" | "fragments" */
  open var bufferedAmount: Number
  open var extensions: String
  open var isPaused: Boolean
  open var protocol: String
  open var readyState: Any
  open var url: String
  open var CONNECTING: Number /* 0 */
  open var OPEN: Number /* 1 */
  open var CLOSING: Number /* 2 */
  open var CLOSED: Number /* 3 */
  open var onopen: ((event: Event) -> Unit)?
  open var onerror: ((event: ErrorEvent) -> Unit)?
  open var onclose: ((event: CloseEvent) -> Unit)?
  open var onmessage: ((event: MessageEvent) -> Unit)?
  open fun close(code: Number = definedExternally, data: String = definedExternally)
  open fun close()
  open fun close(code: Number = definedExternally)
  open fun close(code: Number = definedExternally, data: Buffer = definedExternally)
  open fun ping(data: Any = definedExternally, mask: Boolean = definedExternally, cb: (err: Error) -> Unit = definedExternally)
  open fun pong(data: Any = definedExternally, mask: Boolean = definedExternally, cb: (err: Error) -> Unit = definedExternally)
  open fun send(data: Any, cb: (err: Error) -> Unit = definedExternally)
  open fun send(data: Any)
  open fun send(data: Any, options: `T$13`, cb: (err: Error) -> Unit = definedExternally)
  open fun send(data: Any, options: `T$13`)
  open fun terminate()
  open fun pause()
  open fun resume()
  open fun addEventListener(method: String /* "message" */, cb: (event: MessageEvent) -> Unit, options: EventListenerOptions = definedExternally)
  open fun addEventListener(method: String /* "message" */, cb: (event: MessageEvent) -> Unit)
  open fun addEventListener(method: String /* "close" */, cb: (event: CloseEvent) -> Unit, options: EventListenerOptions = definedExternally)
  open fun addEventListener(method: String /* "close" */, cb: (event: CloseEvent) -> Unit)
  open fun addEventListener(method: String /* "error" */, cb: (event: ErrorEvent) -> Unit, options: EventListenerOptions = definedExternally)
  open fun addEventListener(method: String /* "error" */, cb: (event: ErrorEvent) -> Unit)
  open fun addEventListener(method: String /* "open" */, cb: (event: Event) -> Unit, options: EventListenerOptions = definedExternally)
  open fun addEventListener(method: String /* "open" */, cb: (event: Event) -> Unit)
  open fun removeEventListener(method: String /* "message" */, cb: (event: MessageEvent) -> Unit)
  open fun removeEventListener(method: String /* "close" */, cb: (event: CloseEvent) -> Unit)
  open fun removeEventListener(method: String /* "error" */, cb: (event: ErrorEvent) -> Unit)
  open fun removeEventListener(method: String /* "open" */, cb: (event: Event) -> Unit)
  open fun on(event: String /* "close" */, listener: (code: Number, reason: Buffer) -> Unit): WebSocket /* this */
  open fun on(event: String /* "error" */, listener: (err: Error) -> Unit): WebSocket /* this */
  open fun on(event: String /* "upgrade" */, listener: (request: IncomingMessage) -> Unit): WebSocket /* this */
  open fun on(event: String /* "message" */, listener: (message: Buffer /* Buffer | ArrayBuffer | Array<Buffer> */, isBinary: Boolean) -> Unit): WebSocket /* this */
  open fun on(event: String /* "open" */, listener: (self: WebSocket) -> Unit): WebSocket /* this */
  open fun on(event: String /* "ping" | "pong" */, listener: (self: WebSocket, data: Buffer) -> Unit): WebSocket /* this */
  open fun on(event: String /* "unexpected-response" */, listener: (self: WebSocket, request: ClientRequest, response: IncomingMessage) -> Unit): WebSocket /* this */
  open fun on(event: String, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun on(event: Any, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun once(event: String /* "close" */, listener: (self: WebSocket, code: Number, reason: Buffer) -> Unit): WebSocket /* this */
  open fun once(event: String /* "error" */, listener: (self: WebSocket, err: Error) -> Unit): WebSocket /* this */
  open fun once(event: String /* "upgrade" */, listener: (self: WebSocket, request: IncomingMessage) -> Unit): WebSocket /* this */
  open fun once(event: String /* "message" */, listener: (self: WebSocket, data: Any /* Buffer | ArrayBuffer | Array<Buffer> */, isBinary: Boolean) -> Unit): WebSocket /* this */
  open fun once(event: String /* "open" */, listener: (self: WebSocket) -> Unit): WebSocket /* this */
  open fun once(event: String /* "ping" | "pong" */, listener: (self: WebSocket, data: Buffer) -> Unit): WebSocket /* this */
  open fun once(event: String /* "unexpected-response" */, listener: (self: WebSocket, request: ClientRequest, response: IncomingMessage) -> Unit): WebSocket /* this */
  open fun once(event: String, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun once(event: Any, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun off(event: String /* "close" */, listener: (self: WebSocket, code: Number, reason: Buffer) -> Unit): WebSocket /* this */
  open fun off(event: String /* "error" */, listener: (self: WebSocket, err: Error) -> Unit): WebSocket /* this */
  open fun off(event: String /* "upgrade" */, listener: (self: WebSocket, request: IncomingMessage) -> Unit): WebSocket /* this */
  open fun off(event: String /* "message" */, listener: (self: WebSocket, data: Any /* Buffer | ArrayBuffer | Array<Buffer> */, isBinary: Boolean) -> Unit): WebSocket /* this */
  open fun off(event: String /* "open" */, listener: (self: WebSocket) -> Unit): WebSocket /* this */
  open fun off(event: String /* "ping" | "pong" */, listener: (self: WebSocket, data: Buffer) -> Unit): WebSocket /* this */
  open fun off(event: String /* "unexpected-response" */, listener: (self: WebSocket, request: ClientRequest, response: IncomingMessage) -> Unit): WebSocket /* this */
  open fun off(event: String, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun off(event: Any, listener: (self: WebSocket, args: Any) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "close" */, listener: (code: Number, reason: Buffer) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "error" */, listener: (err: Error) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "upgrade" */, listener: (request: IncomingMessage) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "message" */, listener: (data: Any /* Buffer | ArrayBuffer | Array<Buffer> */, isBinary: Boolean) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "open" */, listener: () -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "ping" | "pong" */, listener: (data: Buffer) -> Unit): WebSocket /* this */
  open fun addListener(event: String /* "unexpected-response" */, listener: (request: ClientRequest, response: IncomingMessage) -> Unit): WebSocket /* this */
  fun addListener(event: String, listener: (args: Any) -> Unit): WebSocket /* this */
  fun addListener(event: Any, listener: (args: Any) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "close" */, listener: (code: Number, reason: Buffer) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "error" */, listener: (err: Error) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "upgrade" */, listener: (request: IncomingMessage) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "message" */, listener: (data: Any /* Buffer | ArrayBuffer | Array<Buffer> */, isBinary: Boolean) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "open" */, listener: () -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "ping" | "pong" */, listener: (data: Buffer) -> Unit): WebSocket /* this */
  open fun removeListener(event: String /* "unexpected-response" */, listener: (request: ClientRequest, response: IncomingMessage) -> Unit): WebSocket /* this */
  fun removeListener(event: String, listener: (args: Any) -> Unit): WebSocket /* this */
  fun removeListener(event: Any, listener: (args: Any) -> Unit): WebSocket /* this */
  interface `T$14` {
    var origin: String
    var secure: Boolean
    var req: IncomingMessage
  }

  interface `L$1` {
    @nativeInvoke
    operator fun invoke(servername: String, cert: String): Boolean

    @nativeInvoke
    operator fun invoke(servername: String, cert: Array<String>): Boolean

    @nativeInvoke
    operator fun invoke(servername: String, cert: Buffer): Boolean

    @nativeInvoke
    operator fun invoke(servername: String, cert: Array<Buffer>): Boolean
  }

  interface ClientOptions : SecureContextOptions {
    var protocol: String?
      get() = definedExternally
      set(value) = definedExternally
    var followRedirects: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    val generateMask: ((mask: Buffer) -> Unit)?
    var handshakeTimeout: Number?
      get() = definedExternally
      set(value) = definedExternally
    var maxRedirects: Number?
      get() = definedExternally
      set(value) = definedExternally
    var perMessageDeflate: dynamic /* Boolean? | PerMessageDeflateOptions? */
      get() = definedExternally
      set(value) = definedExternally
    var localAddress: String?
      get() = definedExternally
      set(value) = definedExternally
    var protocolVersion: Number?
      get() = definedExternally
      set(value) = definedExternally
    var headers: dynamic
    var origin: String?
      get() = definedExternally
      set(value) = definedExternally
    var agent: Agent?
      get() = definedExternally
      set(value) = definedExternally
    var host: String?
      get() = definedExternally
      set(value) = definedExternally
    var family: Number?
      get() = definedExternally
      set(value) = definedExternally
    val checkServerIdentity: `L$1`?
      get() = definedExternally
    var rejectUnauthorized: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var maxPayload: Number?
      get() = definedExternally
      set(value) = definedExternally
    var skipUTF8Validation: Boolean?
      get() = definedExternally
      set(value) = definedExternally
  }

  interface `T$15` {
    var flush: Number?
      get() = definedExternally
      set(value) = definedExternally
    var finishFlush: Number?
      get() = definedExternally
      set(value) = definedExternally
    var chunkSize: Number?
      get() = definedExternally
      set(value) = definedExternally
    var windowBits: Number?
      get() = definedExternally
      set(value) = definedExternally
    var level: Number?
      get() = definedExternally
      set(value) = definedExternally
    var memLevel: Number?
      get() = definedExternally
      set(value) = definedExternally
    var strategy: Number?
      get() = definedExternally
      set(value) = definedExternally
    var dictionary: dynamic /* Buffer? | Array<Buffer>? | DataView? */
      get() = definedExternally
      set(value) = definedExternally
    var info: Boolean?
      get() = definedExternally
      set(value) = definedExternally
  }

  interface PerMessageDeflateOptions {
    var serverNoContextTakeover: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var clientNoContextTakeover: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var serverMaxWindowBits: Number?
      get() = definedExternally
      set(value) = definedExternally
    var clientMaxWindowBits: Number?
      get() = definedExternally
      set(value) = definedExternally
    var zlibDeflateOptions: `T$15`?
      get() = definedExternally
      set(value) = definedExternally
    var zlibInflateOptions: ZlibOptions?
      get() = definedExternally
      set(value) = definedExternally
    var threshold: Number?
      get() = definedExternally
      set(value) = definedExternally
    var concurrencyLimit: Number?
      get() = definedExternally
      set(value) = definedExternally
  }

  interface Event {
    var type: String
    var target: WebSocket
  }

  interface ErrorEvent {
    var error: Any
    var message: String
    var type: String
    var target: WebSocket
  }

  interface CloseEvent {
    var wasClean: Boolean
    var code: Number
    var reason: String
    var type: String
    var target: WebSocket
  }

  interface MessageEvent {
    var data: dynamic /* String | Buffer | ArrayBuffer | Array<Buffer> */
      get() = definedExternally
      set(value) = definedExternally
    var type: String
    var target: WebSocket
  }

  interface EventListenerOptions {
    var once: Boolean?
      get() = definedExternally
      set(value) = definedExternally
  }

  interface ServerOptions {
    var host: String?
      get() = definedExternally
      set(value) = definedExternally
    var port: Number?
      get() = definedExternally
      set(value) = definedExternally
    var backlog: Number?
      get() = definedExternally
      set(value) = definedExternally
    var server: dynamic /* Server__0? | Server__0? */
      get() = definedExternally
      set(value) = definedExternally
    var verifyClient: dynamic /* VerifyClientCallbackAsync? | VerifyClientCallbackSync? */
      get() = definedExternally
      set(value) = definedExternally
    var handleProtocols: ((protocols: Set<String>, request: IncomingMessage) -> dynamic)?
      get() = definedExternally
      set(value) = definedExternally
    var path: String?
      get() = definedExternally
      set(value) = definedExternally
    var noServer: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var clientTracking: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var perMessageDeflate: dynamic /* Boolean? | PerMessageDeflateOptions? */
      get() = definedExternally
      set(value) = definedExternally
    var maxPayload: Number?
      get() = definedExternally
      set(value) = definedExternally
    var skipUTF8Validation: Boolean?
      get() = definedExternally
      set(value) = definedExternally
    var WebSocket: Any?
      get() = definedExternally
      set(value) = definedExternally
  }

  interface AddressInfo {
    var address: String
    var family: String
    var port: Number
  }

  abstract class Server<T : WebSocket>(options: ServerOptions = definedExternally, callback: () -> Unit = definedExternally) {
    open var options: ServerOptions
    open var path: String
    open var clients: Set<T>
    open fun address(): dynamic /* AddressInfo | String */
    open fun close(cb: (err: Error) -> Unit = definedExternally)
    open fun handleUpgrade(request: IncomingMessage, socket: Duplex, upgradeHead: Buffer, callback: (client: T, request: IncomingMessage) -> Unit)
    open fun shouldHandle(request: IncomingMessage): dynamic /* Boolean | Promise<Boolean> */
    open fun on(event: String /* "connection" */, cb: (socket: T, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun on(event: String /* "error" */, cb: (self: Server<T>, error: Error) -> Unit): Server<T> /* this */
    open fun on(event: String /* "headers" */, cb: (self: Server<T>, headers: Array<String>, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun on(event: String /* "close" | "listening" */, cb: (self: Server<T>) -> Unit): Server<T> /* this */
    open fun on(event: String, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun on(event: Any, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun once(event: String /* "connection" */, cb: (self: Server<T>, socket: T, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun once(event: String /* "error" */, cb: (self: Server<T>, error: Error) -> Unit): Server<T> /* this */
    open fun once(event: String /* "headers" */, cb: (self: Server<T>, headers: Array<String>, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun once(event: String /* "close" | "listening" */, cb: (self: Server<T>) -> Unit): Server<T> /* this */
    open fun once(event: String, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun once(event: Any, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun off(event: String /* "connection" */, cb: (self: Server<T>, socket: T, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun off(event: String /* "error" */, cb: (self: Server<T>, error: Error) -> Unit): Server<T> /* this */
    open fun off(event: String /* "headers" */, cb: (self: Server<T>, headers: Array<String>, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun off(event: String /* "close" | "listening" */, cb: (self: Server<T>) -> Unit): Server<T> /* this */
    open fun off(event: String, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun off(event: Any, listener: (self: Server<T>, args: Any) -> Unit): Server<T> /* this */
    open fun addListener(event: String /* "connection" */, cb: (client: T, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun addListener(event: String /* "error" */, cb: (err: Error) -> Unit): Server<T> /* this */
    open fun addListener(event: String /* "headers" */, cb: (headers: Array<String>, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun addListener(event: String /* "close" | "listening" */, cb: () -> Unit): Server<T> /* this */
    fun addListener(event: String, listener: (args: Any) -> Unit): Server<T> /* this */
    fun addListener(event: Any, listener: (args: Any) -> Unit): Server<T> /* this */
    open fun removeListener(event: String /* "connection" */, cb: (client: T) -> Unit): Server<T> /* this */
    open fun removeListener(event: String /* "error" */, cb: (err: Error) -> Unit): Server<T> /* this */
    open fun removeListener(event: String /* "headers" */, cb: (headers: Array<String>, request: IncomingMessage) -> Unit): Server<T> /* this */
    open fun removeListener(event: String /* "close" | "listening" */, cb: () -> Unit): Server<T> /* this */
    fun removeListener(event: String, listener: (args: Any) -> Unit): Server<T> /* this */
    fun removeListener(event: Any, listener: (args: Any) -> Unit): Server<T> /* this */
  }

  companion object {
    var CONNECTING: Number /* 0 */
    var OPEN: Number /* 1 */
    var CLOSING: Number /* 2 */
    var CLOSED: Number /* 3 */
    var WebSocketServer: Any
    var WebSocket: Any
    fun createWebSocketStream(websocket: WebSocket, options: DuplexOptions = definedExternally): Duplex
  }
}
