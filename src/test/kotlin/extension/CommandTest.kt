package extension

import d2r.CommandMessageType
import kotlin.test.Test
import kotlin.test.assertEquals

class CommandTest {
    @Test
    fun typeTest() {
        assertEquals("NEXT_GAME|foo".type(), CommandMessageType.NEXT_GAME)
    }
}
