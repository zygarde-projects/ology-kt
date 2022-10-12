package utils

suspend fun <T> retry(times: Int, block: suspend () -> T?): T? {
  var count = 0
  var result: T? = null

  while (count < times && result == null) {
    result = block()
    count ++
  }

  return result
}
