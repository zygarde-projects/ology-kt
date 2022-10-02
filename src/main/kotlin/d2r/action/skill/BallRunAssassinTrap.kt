package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction
import external.nuttree.getKey
import types.PredefinedPoint

object BallRunAssassinTrap : RepeatableSkillCastAction() {
  private val trapPoint = PredefinedPoint(1389, 945)

  override val castInterval: Int = 8000

  private val key1 = getKey(SkillConfig.get("Trap1"))
  private val key2 = getKey(SkillConfig.get("Trap2"))

  override suspend fun doCast() {
    cast(key1, 1000, trapPoint.randomly(300))
    cast(key1, 1000, trapPoint.randomly(300))
    cast(key1, 1000, trapPoint.randomly(300))
    cast(key1, 1000, trapPoint.randomly(300))
    cast(key2, 1000, trapPoint.randomly(300))
  }
}
