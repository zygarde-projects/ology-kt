package d2r.action.skill

import conf.SkillConfig
import d2r.action.base.RepeatableSkillCastAction
import external.nuttree.getKey
import kotlinx.coroutines.delay

object BarbBo : RepeatableSkillCastAction() {

  override val castInterval: Int = 120 * 1000

  private val key1 = getKey(SkillConfig.get("BO1"))
  private val key2 = getKey(SkillConfig.get("BO2"))
  private val key3 = getKey(SkillConfig.get("BO3"))

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
