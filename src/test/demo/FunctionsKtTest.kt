package demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FunctionsKtTest {

    @Test
    fun nextTwoReturnsAPairOfNextTwoNumbers() {
        val result = nextTwo(1)
        assertEquals(result.first, 2)
        assertEquals(result.second, 3)
    }

    @Test
    fun nextTwoReturnsAPairOfNextTwoNumbersDecomposed() {
        val (first, second) = nextTwo(1)
        assertEquals(first, 2)
        assertEquals(second, 3)
    }

    @Test
    fun getSum() {
    }

    @Test
    fun fact() {
    }
}