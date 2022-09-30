package extension

import conf.SystemConfig
import external.nuttree.imageResource

typealias TemplateImage = String

fun TemplateImage.toImageResource() = imageResource("${SystemConfig.get("resolution")}/resources/template/$this")
