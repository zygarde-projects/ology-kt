package d2r.action.base

import conf.ClientConfig
import d2r.WindowActor
import d2r.constants.MouseLocations
import external.node.AbortController
import external.node.AbortSignal
import external.nuttree.KeyBtn
import external.nuttree.keyboard
import external.nuttree.mouse
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import types.PredefinedPoint

abstract class SkillCastAction : WindowActor {

  private val fastCast = ClientConfig.get("skill_fast_cast").toBoolean()
  private lateinit var abortController: AbortController
  protected lateinit var abortSignal: AbortSignal

  open suspend fun start() {
    init()
    doCast()
  }

  open fun stop() {
    abortController.abort()
  }

  protected fun init() {
    abortController = AbortController()
    abortSignal = abortController.signal
  }

  protected fun getCastTarget(): PredefinedPoint {
    return PredefinedPoint(
      ClientConfig.get("skill_cast_location:x").toIntOrNull() ?: MouseLocations.InGame.charCenter.x,
      ClientConfig.get("skill_cast_location:y").toIntOrNull() ?: MouseLocations.InGame.charCenter.y,
    )
  }

  protected abstract suspend fun doCast()

  protected suspend fun cast(
    key: KeyBtn,
    delayMs: Int,
    pointRandomRange: Int = 0
  ) {
    if (abortSignal.aborted) {
      return
    }
    withTranslatedPoint(getCastTarget().randomly(pointRandomRange)) { point ->
      mouse.move(arrayOf(point))
        .then { keyboard.type(key) }
        .await()
      if (!fastCast) {
        mouse.rightClick().await()
      }
    }
    delay(delayMs.toLong())
  }
}
