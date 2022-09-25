@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface MouseProviderInterface {
    fun setMouseDelay(delay: Number)
    fun setMousePosition(p: Point): Promise<Unit>
    fun currentMousePosition(): Promise<Point>
    fun click(btn: Button): Promise<Unit>
    fun doubleClick(btn: Button): Promise<Unit>
    fun leftClick(): Promise<Unit>
    fun rightClick(): Promise<Unit>
    fun middleClick(): Promise<Unit>
    fun scrollUp(amount: Number): Promise<Unit>
    fun scrollDown(amount: Number): Promise<Unit>
    fun scrollLeft(amount: Number): Promise<Unit>
    fun scrollRight(amount: Number): Promise<Unit>
    fun pressButton(btn: Button): Promise<Unit>
    fun releaseButton(btn: Button): Promise<Unit>
}
