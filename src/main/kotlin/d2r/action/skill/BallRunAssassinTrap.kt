package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction
import external.nuttree.Key
import types.PredefinedPoint

object BallRunAssassinTrap : RepeatableSkillCastAction() {
  private val trapPoint = PredefinedPoint(1389, 945)

  override val castInterval: Int = 8000

  override suspend fun doCast() {
    cast(Key.F1, 1000, trapPoint.randomly(300))
    cast(Key.F1, 1000, trapPoint.randomly(300))
    cast(Key.F1, 1000, trapPoint.randomly(300))
    cast(Key.F1, 1000, trapPoint.randomly(300))
    cast(Key.F2, 1000, trapPoint.randomly(300))
  }
}
