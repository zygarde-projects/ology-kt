@file:JsModule("@nut-tree/nut-js")
@file:JsNonModule

package external.nuttree

import kotlin.js.Promise

external var clipboard: ClipboardClass

external var keyboard: KeyboardClass

external var mouse: MouseClass

external var screen: ScreenClass

external var assert: AssertClass

external var straightTo: (target: dynamic /* Any | Promise<Any> */) -> Promise<Array<Point>>

external var getWindows: () -> Promise<Array<Any>>

external var loadImage: (parameters: String) -> Promise<Any>

external var saveImage: (parameters: Any) -> Promise<Unit>

external var imageResource: (fileName: String) -> Promise<Image>

external var centerOf: (region: Region) -> Promise<Any>

external fun sleep(ms: Number): Promise<Any>
