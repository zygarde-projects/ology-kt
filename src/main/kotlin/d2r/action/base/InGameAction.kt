package d2r.action.base

import types.InGameLifeCycle

interface InGameAction {

  fun lifeCycle(): InGameLifeCycle

  suspend fun exec()

  fun actionName() = "${this::class.simpleName}"

  fun configKey() = "${lifeCycle().lifeCycleKey}:${this::class.simpleName}"
}
