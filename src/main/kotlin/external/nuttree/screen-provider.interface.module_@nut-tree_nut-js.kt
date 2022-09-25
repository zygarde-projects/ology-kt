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

external interface ScreenProviderInterface {
    fun grabScreen(): Promise<Image>
    fun grabScreenRegion(region: Region): Promise<Image>
    fun highlightScreenRegion(region: Region, duration: Number, opacity: Number): Promise<Unit>
    fun screenWidth(): Promise<Number>
    fun screenHeight(): Promise<Number>
    fun screenSize(): Promise<Region>
}
