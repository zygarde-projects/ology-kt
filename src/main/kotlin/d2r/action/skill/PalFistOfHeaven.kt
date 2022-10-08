package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction

object PalFistOfHeaven : RepeatableSkillCastAction() {
  override val castInterval: Int = 1200

  private val key = SkillConfig.getKeyBtn("FistOfHeaven")

  override suspend fun doCast() {
    cast(key, 0, 300)
  }
}
