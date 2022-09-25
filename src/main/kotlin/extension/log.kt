package extension

import kotlinx.coroutines.delay

fun <T> T.log(message: String): T {
    println(message)
    return this
}
