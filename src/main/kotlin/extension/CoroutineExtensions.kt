package extension

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

object CoroutineExtensions {
  private val mainScope = MainScope()

  fun launch(block: suspend () -> Unit) = mainScope.launch {
    block()
  }
}
