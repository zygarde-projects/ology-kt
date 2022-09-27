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
        keyboard.type(Key.Tab).await()
        cleanInput(password.length)
        keyboard.type(password).await()
        delay(100)
    }

    suspend fun submitGameForm() {
        keyboard.type(Key.Return).await()
    }
}
