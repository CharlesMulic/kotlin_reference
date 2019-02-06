package tdd

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PrimeFactorsKtTest {
    @Test
    fun factors() {
//        Assert.assertThat(factorsOf(1), `is`(emptyList()))
        assertEquals(emptyList<Int>(), factorsOf(1))
        assertEquals(listOf(2), factorsOf(2))
        assertEquals(listOf(3), factorsOf(3))
        assertEquals(listOf(2, 2), factorsOf(4))
        assertEquals(listOf(5), factorsOf(5))
        assertEquals(listOf(2, 3), factorsOf(6))
        assertEquals(listOf(7), factorsOf(7))
        assertEquals(listOf(2, 2, 2), factorsOf(8))
        assertEquals(listOf(2, 2, 3, 3, 5, 7, 11, 11, 13), factorsOf(2 * 2 * 3 * 3 * 5 * 7 * 11 * 11 * 13))
    }

    private fun factorsOf(n: Int): List<Int> {
        var remainder = n
        val factors = mutableListOf<Int>()

        var divisor = 2
        while (remainder > 1) {
            while (remainder % divisor == 0) {
                factors.add(divisor)
                remainder /= divisor
            }
            divisor++
        }

        return factors
    }
}