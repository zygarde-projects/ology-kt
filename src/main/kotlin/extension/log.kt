package extension

fun <T> T.log(message: String): T {
  println(message)
  return this
}
