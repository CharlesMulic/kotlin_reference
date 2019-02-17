package talks.bestpracunittesting

import org.assertj.core.api.AbstractFloatAssert
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.assertj.core.data.Offset

// his choice: JUnit5, MockK, AssertJ

// others:
//   Test frameworks: Spek, KotlinTest
//   Mocking: Mockito-Kotlin, MockK
//   Assertions: Strikt, Atrium, HamKrest, Expekt, Kluent, AssertK

class TestSomething {

    @Test
    fun `test something`() {
        val taxRate1 = 0.30001f
        assertThat(taxRate1).isCloseTo(0.3f, Offset.offset(0.001f))
    }

    @Test
    fun `test something better`() {
        val taxRate1 = 0.30001f
        assertThat(taxRate1).isCloseTo(0.3f)
    }

    fun AbstractFloatAssert<*>.isCloseTo(expected:Float) = this.isCloseTo(expected, Offset.offset(0.001f))
}