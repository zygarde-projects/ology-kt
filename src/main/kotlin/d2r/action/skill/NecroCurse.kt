package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction

object NecroCurse : RepeatableSkillCastAction() {
  override val castInterval: Int = 3000

  private val keyCurse = SkillConfig.getKeyBtn("Curse")

  override suspend fun doCast() {
    cast(keyCurse, 1000, 0)
  }
}
