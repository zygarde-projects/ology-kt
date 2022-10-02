package command.dev

import command.base.NoArgCommand
import d2r.constants.DimensionConstants.baseScreenH
import d2r.constants.DimensionConstants.baseScreenW
import external.nuttree.mouse
import external.nuttree.screen
import kotlinx.coroutines.await
import timers.setInterval
import types.PredefinedPoint
import utils.PointTranslator

object MouseTrackingCommand : NoArgCommand("mouse-tracking") {
  override suspend fun handle() {
    val width = screen.width().await()
    val height = screen.height().await()
    println("screen $width x $height")

    val pointTranslator = PointTranslator(width.toInt(), height.toInt(), baseScreenW, baseScreenH)
    println("start mouse tracking")
    setInterval({
      mouse.getPosition().then {
        val translated = pointTranslator.translate(it)
        println("position: $it -> ${PredefinedPoint(translated.x, translated.y)}")
      }
    }, 1000)
  }
}
