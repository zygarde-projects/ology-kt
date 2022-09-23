package external.wincontrol

@JsModule("win-control")  // only for windows
@JsNonModule
external object Window {
    fun getByTitle(title: String): WindowInstance?
}
