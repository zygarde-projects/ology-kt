@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.Promise

external interface ScreenProviderInterface {
  fun grabScreen(): Promise<Image>
  fun grabScreenRegion(region: Region): Promise<Image>
  fun highlightScreenRegion(region: Region, duration: Number, opacity: Number): Promise<Unit>
  fun screenWidth(): Promise<Number>
  fun screenHeight(): Promise<Number>
  fun screenSize(): Promise<Region>
}
