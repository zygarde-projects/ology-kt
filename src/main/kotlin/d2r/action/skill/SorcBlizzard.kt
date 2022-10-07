package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction

object SorcBlizzard : RepeatableSkillCastAction() {
  override val castInterval: Int = 2000

  override suspend fun doCast() {
    castByConfig("Blizzard", 0, 300)
  }
}
