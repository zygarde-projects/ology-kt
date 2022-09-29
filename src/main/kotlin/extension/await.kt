package extension

import kotlinx.coroutines.delay
import kotlin.coroutines.*
import kotlin.js.Promise
import kotlin.random.Random

fun launch(block: suspend () -> Unit) {
  block.startCoroutine(object : Continuation<Unit> {
    override val context: CoroutineContext get() = EmptyCoroutineContext
    override fun resumeWith(result: Result<Unit>) {}
  })
}

suspend fun <T> Promise<T>.await() = suspendCoroutine<T?> { cont ->
  then { cont.resume(it) }
    .catch {
      println(it)
      cont.resume(null)
    }
}

suspend fun <T> T.wait(ms: Long): T {
  delay(ms)
  return this
}

suspend fun <T> T.waitRandomly(): T {
  delay(50 + Random.nextLong(0, 50))
  return this
}
