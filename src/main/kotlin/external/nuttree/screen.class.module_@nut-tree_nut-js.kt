@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import tsstdlib.Map
import kotlin.js.Promise

typealias FindHookCallback = (target: MatchResult) -> Promise<Unit>

external interface `T$0` {
  var confidence: Number
  var autoHighlight: Boolean
  var highlightDurationMs: Number
  var highlightOpacity: Number
  var resourceDirectory: String
}

external open class ScreenClass(providerRegistry: ProviderRegistry, findHooks: Map<Image, Array<FindHookCallback>> = definedExternally) {
  open var providerRegistry: Any
  open var findHooks: Any
  open var config: `T$0`
  open fun width(): Promise<Number>
  open fun height(): Promise<Number>
  open fun find(template: Image, params: OptionalSearchParameters = definedExternally): Promise<Region>
  open fun find(template: Image): Promise<Region>
  open fun find(template: Promise<Image>, params: OptionalSearchParameters = definedExternally): Promise<Region>
  open fun find(template: Promise<Image>): Promise<Region>
  open fun findAll(template: FirstArgumentType<Any>, params: OptionalSearchParameters = definedExternally): Promise<Array<Region>>
  open fun highlight(regionToHighlight: Region): Promise<Region>
  open fun highlight(regionToHighlight: Promise<Region>): Promise<Region>
  open fun waitFor(templateImage: FirstArgumentType<Any>, timeoutMs: Number = definedExternally, updateInterval: Number = definedExternally, params: OptionalSearchParameters = definedExternally): Promise<Region>
  open fun on(templateImage: Image, callback: FindHookCallback)
  open fun capture(fileName: String, fileFormat: FileType = definedExternally, filePath: String = definedExternally, fileNamePrefix: String = definedExternally, fileNamePostfix: String = definedExternally): Promise<String>
  open fun grab(): Promise<Image>
  open fun captureRegion(fileName: String, regionToCapture: Region, fileFormat: FileType = definedExternally, filePath: String = definedExternally, fileNamePrefix: String = definedExternally, fileNamePostfix: String = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Region): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Region, fileFormat: FileType = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Region, fileFormat: FileType = definedExternally, filePath: String = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Region, fileFormat: FileType = definedExternally, filePath: String = definedExternally, fileNamePrefix: String = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Promise<Region>, fileFormat: FileType = definedExternally, filePath: String = definedExternally, fileNamePrefix: String = definedExternally, fileNamePostfix: String = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Promise<Region>): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Promise<Region>, fileFormat: FileType = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Promise<Region>, fileFormat: FileType = definedExternally, filePath: String = definedExternally): Promise<String>
  open fun captureRegion(fileName: String, regionToCapture: Promise<Region>, fileFormat: FileType = definedExternally, filePath: String = definedExternally, fileNamePrefix: String = definedExternally): Promise<String>
  open fun grabRegion(regionToGrab: Region): Promise<Image>
  open fun grabRegion(regionToGrab: Promise<Region>): Promise<Image>
  open fun colorAt(point: Point): Promise<Any>
  open fun colorAt(point: Promise<Point>): Promise<Any>
  open var saveImage: Any
  open var getFindParameters: Any

  companion object {
    var getNeedle: Any
  }
}
