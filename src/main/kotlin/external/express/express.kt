package external.express

open external class Express {
  fun listen(port: Int, block: () -> Unit)
  fun get(path: String, block: (req: dynamic, res: dynamic) -> dynamic)
  fun use(middlewareFunction: dynamic)
  fun use(path: String, middlewareFunction: dynamic)
}

@JsModule("express")
@JsNonModule
external class express : Express {
  companion object {
    fun static(root: String)
  }
}
