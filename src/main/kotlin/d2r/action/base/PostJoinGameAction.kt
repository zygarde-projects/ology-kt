package d2r.action.base

import types.InGameLifeCycle

abstract class PostJoinGameAction : InGameAction {
  override fun lifeCycle() = InGameLifeCycle.POST_JOIN_GAME
}
