package d2r.action.base

import types.InGameLifeCycle

interface NoLifeCycleAction : InGameAction {
  override fun lifeCycle() = InGameLifeCycle.NONE
}
