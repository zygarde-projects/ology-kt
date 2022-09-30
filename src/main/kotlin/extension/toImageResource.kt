package extension

import conf.SystemConfig
import external.nuttree.imageResource

typealias TemplateImage = String

fun TemplateImage.toImageResource() = imageResource("resources/template/${SystemConfig.get("resolution")}/$this")
