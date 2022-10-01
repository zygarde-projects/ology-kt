package d2r

import extension.waitRandomly
import external.nuttree.Key
import external.nuttree.KeyBtn
import external.nuttree.keyboard
import kotlinx.coroutines.await
import kotlinx.coroutines.delay

object KeyboardController {
  suspend fun cleanInput(size: Int? = null) = with(keyboard) {
    type(Key.End).await()
    if (size == null) {
      pressKey(Key.LeftShift)
        .then { type(Key.Home) }
        .then { releaseKey(Key.LeftShift) }
        .then { type(Key.Delete) }
        .await()
      return
    }

    repeat(size) {
      delay(100)
      keyboard.type(Key.Backspace).await()
    }
  }

  suspend fun inputGameNameAndPassword(
    name: String,
    password: String,
  ) {
    cleanInput()
    keyboard.type(name).await()

    delay(500)
    keyboard.type(Key.Tab).await()
    cleanInput()
    keyboard.type(password).await()

    delay(100)
  }

  suspend fun submitGameForm() {
    keyboard.type(Key.Return).await()
  }

  suspend fun pressAndReleaseKey(key: KeyBtn) {
    keyboard.pressKey(key).await().waitRandomly()
    keyboard.releaseKey(key).await()
  }
}
