package external.nuttree

data class Region(
    val left: Int,
    val top: Int,
    val width: Int,
    val height: Int
)

data class Point(
    val left: Int,
    val top: Int
)

data class OptionalSearchParameters(
    val searchRegion: Region? = null,
    val confidence: Int? = null,
    val searchMultipleScales: Boolean? = null
)

data class PixelDensity(
    val scaleX: Int,
    val scaleY: Int
)

data class NutImage(
    val width: Int,
    val height: Int,
    val data: Any,
    val channels: Int,
    val id: String,
    val pixelDensity: PixelDensity
)
