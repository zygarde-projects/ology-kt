package external.wincontrol

@JsModule("@zygarde-projects/win-control")  // only for windows
@JsNonModule
external object Window {
    fun getByTitle(title: String): WindowInstance?
}
