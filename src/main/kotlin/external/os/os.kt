package external.os

@JsModule("os")
@JsNonModule
external object OS {
  fun networkInterfaces(): JSON
}
