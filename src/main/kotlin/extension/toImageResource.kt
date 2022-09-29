package extension

import __dirname
import external.nuttree.imageResource

typealias TemplateImage = String

fun TemplateImage.toImageResource() = imageResource("$__dirname/../resources/template/$this")
