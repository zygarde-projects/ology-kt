package d2r.action.skill

import d2r.action.base.RepeatableSkillCastAction

object SorcHydra : RepeatableSkillCastAction() {
  override val castInterval: Int = 9000

  override suspend fun doCast() {
    castByConfig("Hydra", 500, 300)
    castByConfig("Hydra", 500, 300)
    castByConfig("Hydra", 500, 300)
    castByConfig("Hydra", 500, 300)
    castByConfig("Hydra", 500, 300)
    castByConfig("Hydra", 500, 300)
  }
}
