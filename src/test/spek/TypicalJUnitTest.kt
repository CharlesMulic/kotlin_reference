package spek.junit

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TypicalJUnitTest {
    val calculator = Calculator()

    @Test
    fun `2 + 4 = 6`() {
        val result = calculator.add(2, 4)
        assertEquals(6, result)
    }
}

class Calculator {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

}
