//@file:JsModule("win-control")  // only for windows
//@file:JsNonModule

package external.wincontrol

external object Window {
    fun getByTitle(title: String): WindowInstance?
}
