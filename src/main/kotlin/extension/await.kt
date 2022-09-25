package extension

import kotlinx.coroutines.delay
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine
import kotlin.js.Promise

fun launch(block: suspend () -> Unit) {
    block.startCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext get() = EmptyCoroutineContext
        override fun resumeWith(result: Result<Unit>) {}
    })
}

suspend fun <T> Promise<T>.await() = suspendCoroutine<T?> { cont ->
    then { cont.resume(it) }.catch { cont.resume(null) }
}

suspend fun <T> T.wait(ms: Long): T {
    delay(ms)
    return this
}
