package extension

import kotlin.js.Promise

object PromiseExtensions {
  fun <T> Promise<T?>.catchReturnNull(): Promise<T?> = catch {
    null
  }
}
