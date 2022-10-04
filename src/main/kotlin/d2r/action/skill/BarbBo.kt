package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction
import kotlinx.coroutines.delay

object BarbBo : RepeatableSkillCastAction() {

  override val castInterval: Int = 120 * 1000

  private val key1 = SkillConfig.getKeyBtn("BO1")
  private val key2 = SkillConfig.getKeyBtn("BO2")
  private val key3 = SkillConfig.getKeyBtn("BO3")

  override suspend fun doCast() {
    cast(key1, 1000)
    cast(key1, 1000)
    cast(key2, 1000)
    cast(key3, 1000)
    delay(15000)
    cast(key1, 1000)
    cast(key1, 1000)
    cast(key2, 1000)
    cast(key3, 1000)
  }
}
