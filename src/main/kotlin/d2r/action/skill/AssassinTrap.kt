package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction

object AssassinTrap : RepeatableSkillCastAction() {
  override val castInterval: Int = 12000

  private val key1 = SkillConfig.getKeyBtn("Trap1")
  private val key2 = SkillConfig.getKeyBtn("Trap2")

  override suspend fun doCast() {
    cast(key1, 1000, 300)
    cast(key1, 1000, 300)
    cast(key1, 1000, 300)
    cast(key1, 1000, 300)
    cast(key2, 1000, 300)
  }
}
