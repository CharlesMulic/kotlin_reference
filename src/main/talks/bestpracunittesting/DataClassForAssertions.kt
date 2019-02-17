package talks.bestpracunittesting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataClassForAssertions {

    @Test
    fun `example test`() {
        val expectedDesign = Design(id = 2, userId = 9, name = "cat")
        val actualDesign = Design(id = 1, userId = 9, name = "Cat")

        // using a wrapper data class instead of testing individual values can give you more context for test failures
        // also makes test code more concise, don't need to test all 3 individually
        assertThat(actualDesign).isEqualTo(expectedDesign)
    }

    @Test
    fun `example list test`() {
        val actualDesigns = listOf(
            Design(1, 2, "Cat"),
            Design(2, 2, "Dog")
        )

        // check the list contains the same items, in the same order
        assertThat(actualDesigns).containsExactly(
            Design(2, 2, "Dog"),
            Design(1, 2, "Cat")
        )
    }

    @Test
    fun `example of test ignoring certain fields`() {
        val actualDesign = Design(1, 2, "Cat")
        val expectedDesign = Design(0, 2, "Cat") // id's are different
        assertThat(actualDesign).isEqualToIgnoringGivenFields(expectedDesign, "id")

        // inverse, ignore all properties except the ones I explicitly give you to compare
        assertThat(actualDesign).isEqualToComparingOnlyGivenFields(expectedDesign, "userId", "name")
    }

    @Test
    fun `example list test with ignored fields`() {
        val actualDesigns = listOf(
            Design(1, 2, "Cat"),
            Design(2, 2, "Dog")
        )

        // ignoring id explicitly in the check
        assertThat(actualDesigns).usingElementComparatorIgnoringFields("id").containsExactly(
            Design(111, 2, "Cat"),
            Design(222, 2, "Dog")
        )

        // explicitly checking certain fields
        assertThat(actualDesigns).usingElementComparatorOnFields("userId", "name").containsExactly(
            Design(111, 2, "Cat"),
            Design(222, 2, "Dog")
        )
    }
}

// data class implements equals() and toString() out of the box, good for basic testing
data class Design(val id: Int, val userId: Int, val name: String)
