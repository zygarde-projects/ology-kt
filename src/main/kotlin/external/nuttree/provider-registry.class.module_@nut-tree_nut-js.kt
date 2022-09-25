@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

external interface ProviderRegistry {
    fun getClipboard(): ClipboardProviderInterface
    fun registerClipboardProvider(value: ClipboardProviderInterface)
    fun getKeyboard(): KeyboardProviderInterface
    fun registerKeyboardProvider(value: KeyboardProviderInterface)
    fun getMouse(): MouseProviderInterface
    fun registerMouseProvider(value: MouseProviderInterface)
    fun getScreen(): ScreenProviderInterface
    fun registerScreenProvider(value: ScreenProviderInterface)
    fun getWindow(): WindowProviderInterface
    fun registerWindowProvider(value: WindowProviderInterface)
    fun getImageFinder(): ImageFinderInterface
    fun registerImageFinder(value: ImageFinderInterface)
    fun getImageReader(): ImageReader
    fun registerImageReader(value: ImageReader)
    fun getImageWriter(): ImageWriter
    fun registerImageWriter(value: ImageWriter)
    fun getImageProcessor(): ImageProcessor
    fun registerImageProcessor(value: ImageProcessor)
}

external open class DefaultProviderRegistry : ProviderRegistry {
    open var _clipboard: Any
    open var _finder: Any
    open var _keyboard: Any
    open var _mouse: Any
    open var _screen: Any
    open var _window: Any
    open var _imageReader: Any
    open var _imageWriter: Any
    open var _imageProcessor: Any
    override fun getClipboard(): ClipboardProviderInterface
    override fun registerClipboardProvider(value: ClipboardProviderInterface)
    override fun getImageFinder(): ImageFinderInterface
    override fun registerImageFinder(value: ImageFinderInterface)
    override fun getKeyboard(): KeyboardProviderInterface
    override fun registerKeyboardProvider(value: KeyboardProviderInterface)
    override fun getMouse(): MouseProviderInterface
    override fun registerMouseProvider(value: MouseProviderInterface)
    override fun getScreen(): ScreenProviderInterface
    override fun registerScreenProvider(value: ScreenProviderInterface)
    override fun getWindow(): WindowProviderInterface
    override fun registerWindowProvider(value: WindowProviderInterface)
    override fun getImageReader(): ImageReader
    override fun registerImageReader(value: ImageReader)
    override fun getImageWriter(): ImageWriter
    override fun registerImageWriter(value: ImageWriter)
    override fun getImageProcessor(): ImageProcessor
    override fun registerImageProcessor(value: ImageProcessor)
}
