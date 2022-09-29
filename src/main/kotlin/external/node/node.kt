package external.node

import NodeJS.Process
import org.w3c.dom.events.Event

@JsModule("process")
@JsNonModule
external val process: Process


@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external class AbortController {
  var signal: AbortSignal
  fun abort()
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface AbortSignal {
  var aborted: Boolean
  var onabort: ((self: AbortSignal, ev: Event) -> Any)?

  companion object {
    var prototype: AbortSignal
  }
}
