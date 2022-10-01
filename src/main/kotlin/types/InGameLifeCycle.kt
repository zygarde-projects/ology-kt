package types

enum class InGameLifeCycle(
  val lifeCycleKey: String
) {
  NONE("none"),
  POST_JOIN_GAME(
    "post_join_game"
  ),
  POST_ENTER_TP(
    "post_enter_tp"
  ),
  //
  ;
}
