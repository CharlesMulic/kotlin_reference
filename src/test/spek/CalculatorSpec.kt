package spek

//import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object CalculatorSpec : Spek({
    // delegate to lambda for object creation, gets created every time
    // avoid state sharing between tr ests with memoized
    val calculator by memoized { Calculator() }

    describe("2 + 4") {
        val result by memoized { calculator.add(2, 4) }

        it("equals 6") {
            assertEquals(6, result)
        }
    }
})

class Calculator {
    fun add(x: Int, y: Int): Int {
        return x + y
    }
}