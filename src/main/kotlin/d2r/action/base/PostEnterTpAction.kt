package d2r.action.base

import types.InGameLifeCycle

interface PostEnterTpAction : InGameAction {
  override fun lifeCycle() = InGameLifeCycle.POST_ENTER_TP
}
