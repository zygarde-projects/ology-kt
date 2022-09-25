@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

package external.nuttree

import url.URL
import kotlin.js.Promise

external fun fetchFromUrl(url: String): Promise<Image>

external fun fetchFromUrl(url: URL): Promise<Image>
