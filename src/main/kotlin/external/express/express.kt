package external.express
external class Express {
    fun listen(port: Int, block: () -> Unit)
    fun get(path: String, block: (req: dynamic, res: dynamic) -> dynamic)
}

@JsModule("express")
@JsNonModule
external fun express(): Express
