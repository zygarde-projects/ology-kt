@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface `T$10` {
  var autoDelayMs: Number
  var mouseSpeed: Number
}

external open class MouseClass(providerRegistry: ProviderRegistry) {
  open var providerRegistry: Any
  open var config: `T$10`
  open fun setPosition(target: Point): Promise<MouseClass>
  open fun getPosition(): Promise<Point>
  open fun move(path: Array<Point>, movementType: EasingFunction = definedExternally): Promise<MouseClass>
  open fun move(path: Array<Point>): Promise<MouseClass>
  open fun move(path: Promise<Array<Point>>, movementType: EasingFunction = definedExternally): Promise<MouseClass>
  open fun move(path: Promise<Array<Point>>): Promise<MouseClass>
  open fun leftClick(): Promise<MouseClass>
  open fun rightClick(): Promise<MouseClass>
  open fun scrollDown(amount: Number): Promise<MouseClass>
  open fun scrollUp(amount: Number): Promise<MouseClass>
  open fun scrollLeft(amount: Number): Promise<MouseClass>
  open fun scrollRight(amount: Number): Promise<MouseClass>
  open fun drag(path: Array<Point>): Promise<MouseClass>
  open fun drag(path: Promise<Array<Point>>): Promise<MouseClass>
  open fun pressButton(btn: Button): Promise<MouseClass>
  open fun releaseButton(btn: Button): Promise<MouseClass>
  open fun click(btn: Button): Promise<MouseClass>
  open fun doubleClick(btn: Button): Promise<MouseClass>
}
