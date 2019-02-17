package talks.bestpracunittesting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ParameterizedTests {

    @ParameterizedTest
    @MethodSource("validTokenProvider")
    fun `parse valid tokens`(testData: TestData) {
        val parsedToken = parse(testData.input)
        assertThat(parsedToken).isEqualTo(testData.expectedToken)
    }

    private fun validTokenProvider() = Stream.of(
        TestData(input = "1511443755_2", expectedToken = Token(1511443755, "2")),
        TestData(input = "151175_13521", expectedToken = Token(151175, "13521")),
        TestData(input = "151144375_id", expectedToken = Token(151144375, "id")),
        TestData(input = "1511443759_1", expectedToken = Token(1511443759, "1")),
        TestData(input = null, expectedToken = null)
    )
}

fun parse(value: String?): Token? {
    if (value == null) {
        return null
    }
    val parts = value.split("_")
    val timestamp = parts[0].toLong()
    val id = parts[1].toString()
    return Token(timestamp, id)
}

data class Token(val timestamp: Long, val id: String)
data class TestData(val input: String?, val expectedToken: Token?)