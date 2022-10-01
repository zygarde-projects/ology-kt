package d2r

import extension.waitRandomly
import external.nuttree.Key
import external.nuttree.KeyBtn
import external.nuttree.keyboard
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlin.math.min

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
    previousGameName: String? = null,
  ) {
    if (previousGameName != null) {
      var lengthToRemove = name.length
      for (i in (0 until min(name.length, previousGameName.length))) {
        if (name[i] == previousGameName[i]) {
          lengthToRemove--
        } else {
          break
        }
      }
      cleanInput(lengthToRemove)

      keyboard.type(name.substring(name.length - lengthToRemove)).await()
    } else {
      cleanInput()
      keyboard.type(name).await()
    }

    if (previousGameName == null) {
      delay(100)
      keyboard.type(Key.Tab).await()
      cleanInput(password.length)
      keyboard.type(password).await()
    }

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
