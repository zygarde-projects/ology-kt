package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction

object NecroSummon : RepeatableSkillCastAction() {
  override val castInterval: Int = 8000

  private val keySkeleton = SkillConfig.getKeyBtn("SummonSkeleton")
  private val keyGolem = SkillConfig.getKeyBtn("SummonGolem")

  override suspend fun doCast() {
    cast(keyGolem, 1000, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
  }
}
