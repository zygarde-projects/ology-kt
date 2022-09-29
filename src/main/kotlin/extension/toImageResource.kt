package extension

import external.nuttree.imageResource

typealias TemplateImage = String

fun TemplateImage.toImageResource() = imageResource("resources/template/$this")
