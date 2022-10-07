package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction

object SorcMeteor : RepeatableSkillCastAction() {
  override val castInterval: Int = 2000

  override suspend fun doCast() {
    castByConfig("Meteor", 0, 300)
  }
}
