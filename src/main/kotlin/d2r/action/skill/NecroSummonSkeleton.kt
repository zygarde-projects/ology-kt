package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction
import kotlinx.coroutines.delay

object NecroSummonSkeleton : RepeatableSkillCastAction() {
  override val castInterval: Int = 30000

  private val keySkeleton = SkillConfig.getKeyBtn("SummonSkeleton")

  override suspend fun doCast() {
    delay(1000)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
    cast(keySkeleton, 500, 300)
  }
}
