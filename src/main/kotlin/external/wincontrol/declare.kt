package external.wincontrol

@JsModule("@zygarde-projects/win-control")  // only for windows
@JsNonModule
external object WinControl {
    val Window: Window
}

external interface Window {
    fun getByTitle(title: String): WindowInstance?
}
