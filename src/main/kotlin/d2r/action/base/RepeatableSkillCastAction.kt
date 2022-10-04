package d2r.action.base

import NodeJS.Timeout
import clearInterval
import extension.CoroutineExtensions.launch
import setInterval

abstract class RepeatableSkillCastAction : SkillCastAction() {

  protected abstract val castInterval: Int

  protected open var castImmediate: Boolean = true

  private var timeout: Timeout? = null

  override suspend fun start() {
    init()
    timeout = setInterval({
      if (!abortSignal.aborted) {
        launch {
          doCast()
        }
      }
    }, castInterval)
    if (castImmediate) {
      doCast()
    }
  }

  override fun stop() {
    super.stop()
    timeout?.let(::clearInterval)
  }

}
