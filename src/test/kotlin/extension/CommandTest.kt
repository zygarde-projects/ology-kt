package extension

import d2r.CommandMessageType
import kotlin.test.Test
import kotlin.test.assertEquals

class CommandTest {
    @Test
    fun typeTest() {
        assertEquals("CREATE_GAME|foo".type(), CommandMessageType.CREATE_GAME)
    }
}
