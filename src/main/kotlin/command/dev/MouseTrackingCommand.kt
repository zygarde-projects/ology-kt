package command.dev

import command.base.NoArgCommand
import d2r.constants.DimensionConstants.baseScreenH
import d2r.constants.DimensionConstants.baseScreenW
import extension.await
import extension.launch
import external.nuttree.mouse
import external.nuttree.screen
import timers.setInterval
import utils.PointTranslator

object MouseTrackingCommand : NoArgCommand("mouse-tracking") {
  override fun handle() {
    launch {
      val width = screen.width().await()
      val height = screen.height().await()
      println("screen $width x $height")

      val pointTranslator = PointTranslator(width!!.toInt(), height!!.toInt(), baseScreenW, baseScreenH)
      println("start mouse tracking")
      setInterval({
        mouse.getPosition().then {
          println("position: $it -> ${pointTranslator.translate(it)}")
        }
      }, 1000)
    }


  }
}
