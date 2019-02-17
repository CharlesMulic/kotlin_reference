package talks.bestpracunittesting.test2

import org.junit.jupiter.api.Test
import java.time.Instant
import java.util.*

class HelperFuncForObjCreation {
    fun createDesign(
        id: Int = 1, name: String = "Cat", date: Instant = Instant.ofEpochSecond(1518278198),
        tags: Map<Locale, List<Tag>> = mapOf(
            Locale.US to listOf(Tag(value = "$name in English"))
        )
    ) = Design(id = id, userId = 9, name = name, dateCreated = date, tags = tags)

    @Test
    fun `some test`() {
        val testDesign = createDesign()
        val testDesign2 = createDesign(id = 1, name = "Fox")
    }
}

data class Design(
    val id: Int,
    val userId: Int,
    val name: String,
    val dateCreated: Instant,
    val tags: Map<Locale, List<Tag>>
)

data class Tag(val value: String)
