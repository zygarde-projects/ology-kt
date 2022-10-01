package d2r.action.base

import types.InGameLifeCycle

abstract class NoLifeCycleAction : InGameAction {
  override fun lifeCycle() = InGameLifeCycle.NONE
}
