package d2r.action.base

import types.InGameLifeCycle

abstract class PostEnterTpAction : InGameAction {
  override fun lifeCycle() = InGameLifeCycle.POST_ENTER_TP
}
