package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction
import external.nuttree.Key
import kotlinx.coroutines.delay

object BarbBo : RepeatableSkillCastAction() {

  override val castInterval: Int = 120 * 1000

  override suspend fun doCast() {
    cast(Key.F1, 1000)
    cast(Key.F1, 1000)
    cast(Key.F2, 1000)
    cast(Key.F3, 1000)
    delay(15000)
    cast(Key.F1, 1000)
    cast(Key.F1, 1000)
    cast(Key.F2, 1000)
    cast(Key.F3, 1000)
  }
}
