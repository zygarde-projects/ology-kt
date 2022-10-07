package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction

object NecroSummonGolem : RepeatableSkillCastAction() {
  override val castInterval: Int = 120 * 1000

  override suspend fun doCast() {
    castByConfig("SummonGolem", 0, 300)
  }
}
