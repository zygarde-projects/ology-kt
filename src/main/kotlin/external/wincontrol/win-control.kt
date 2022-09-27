package external.wincontrol

data class Dimensions(
    val left: Int,
    val right: Int,
    val top: Int,
    val bottom: Int
)

external class WindowInstance {
    fun setForeground()
    fun getDimensions(): Dimensions?
}
