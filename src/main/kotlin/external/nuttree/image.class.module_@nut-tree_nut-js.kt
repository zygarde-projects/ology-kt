@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import Buffer
import kotlin.js.Promise

external interface `T$3` {
  var scaleX: Number
  var scaleY: Number
}

external open class Image(width: Number, height: Number, data: Buffer, channels: Number, id: String, colorMode: ColorMode = definedExternally, pixelDensity: `T$3` = definedExternally) {
  open var width: Number
  open var height: Number
  open var data: Buffer
  open var channels: Number
  open var id: String
  open var colorMode: ColorMode
  open var pixelDensity: `T$3`
  open fun toRGB(): Promise<Image>
  open fun toBGR(): Promise<Image>

  companion object {
    fun fromRGBData(width: Number, height: Number, data: Buffer, channels: Number, id: String): Image
  }
}
