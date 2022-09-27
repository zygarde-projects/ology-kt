package d2r

import d2r.constants.GeneralConstants.gameWindowTitle
import extension.DimensionExtensions.translatePoint
import extension.DimensionExtensions.translateRegion
import external.nuttree.Point
import external.nuttree.Region
import external.wincontrol.Dimensions
import external.wincontrol.WinControl.Window
import types.PredefinedPoint
import types.PredefinedRegion

interface WindowActor {
    suspend fun <T> withWindowDimension(block: suspend (d: Dimensions) -> T): T {
        val dimensions = Window.getByTitle(gameWindowTitle)?.getDimensions()
        if (dimensions != null) {
            return block.invoke(dimensions)
        }
        throw IllegalStateException("game not running")
    }

    suspend fun <T> withTranslatedPoint(predefinedPoint: PredefinedPoint, block: suspend (p: Point) -> T): T {
        return withWindowDimension { d ->
            block(d.translatePoint(predefinedPoint))
        }
    }

    suspend fun <T> withTranslatedRegion(predefinedRegion: PredefinedRegion, block: suspend (region: Region) -> T): T {
        return withWindowDimension { d ->
            block(d.translateRegion(predefinedRegion))
        }
    }
}
