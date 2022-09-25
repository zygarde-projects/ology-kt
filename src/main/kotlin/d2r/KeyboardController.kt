package d2r

import external.nuttree.Key
import external.nuttree.keyboard
import kotlinx.coroutines.await
import kotlinx.coroutines.delay

object KeyboardController {
    suspend fun cleanInput(size: Int) {
        delay(100)
        keyboard.pressKey(Key.End).await()
        keyboard.releaseKey(Key.End).await()
        IntRange(0, size).forEach { _ ->
            delay(100)
            keyboard.pressKey(Key.Backspace).await()
            keyboard.releaseKey(Key.Backspace).await()
        }
    }

    suspend fun inputGameNameAndPassword(name: String, password: String) {
        cleanInput(name.length)
        keyboard.type(name).await()
        delay(100)
        keyboard.pressKey(Key.Tab).await()
        keyboard.releaseKey(Key.Tab).await()
        cleanInput(password.length)
    }

    suspend fun submitGameForm() {
        keyboard.pressKey(Key.Return).await()
        keyboard.releaseKey(Key.Return).await()
    }
}
