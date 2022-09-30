package extension

import kotlinx.coroutines.delay
import kotlin.random.Random

suspend fun <T> T.wait(ms: Long): T {
  delay(ms)
  return this
}

suspend fun <T> T.waitRandomly(): T {
  delay(50 + Random.nextLong(0, 50))
  return this
}
