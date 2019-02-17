package talks.bestpracunittesting

import io.mockk.clearMocks
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DesignControllerTest {

//    private lateinit var repo: DesignRepository
//    private lateinit var client: DesignClient
//    private lateinit var controller: DesignController
//
//    @BeforeEach
//    fun init() {
//        // creating mocks before each method is expensive
//        repo = mockk()
//        client = mockk()
//        controller = DesignController(repo, client)
//    }

    private val repo: DesignRepository = mockk()
    private val client: DesignClient = mockk()
    private val controller: DesignController = DesignController(repo, client)

    @BeforeEach
    fun init() {
        clearMocks(repo, client) // faster
    }

    @Nested
    inner class GetDesigns {
        @Test
        fun `all fields are included`() {
        }

        @Test
        fun `limit parameter`() {
        }
    }

    @Nested
    inner class DeleteDesign {
        @Test
        fun `design is removed in db`() {
        }
    }
}

class DesignRepository {

}

class DesignClient {

}

class DesignController(val repo: DesignRepository, val client: DesignClient)
