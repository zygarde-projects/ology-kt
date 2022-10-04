package types

enum class InGameLifeCycle(
  val lifeCycleKey: String
) {
  NONE("none"),
  POST_JOIN_GAME(
    "post_join_game"
  ),
  SKILL_CAST(
    "skill_cast"
  ),
  //
  ;
}
