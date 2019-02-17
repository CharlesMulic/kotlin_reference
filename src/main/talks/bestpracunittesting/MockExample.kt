package talks.bestpracunittesting.test

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MockExample {

    @Test
    fun `test using a mock`() {
        val clientMock: UserClient = mockk()
        every { clientMock.getUser(any()) } returns User(id = 3, name = "mocked")

        val userUpdater = UserUpdater(clientMock)
        val updatedUser = userUpdater.updateUser(User(1, null))

        verify { clientMock.getUser(1) } // verify it was called once and only once

        // check the mock values
        assertThat(updatedUser.id).isEqualTo(3)
        assertThat(updatedUser.name).isEqualTo("mocked")
    }

    @Test
    fun `test using relaxed mocks`() {
        val clientMock: UserClient = mockk(relaxed = true)

        val userUpdater = UserUpdater(clientMock)
        val updatedUser = userUpdater.updateUser(User(1, null))

        verify { clientMock.getUser(1) } // verify it was called once and only once

        // check the mock values, uses default values because relaxed = true
        assertThat(updatedUser.id).isEqualTo(0)
        assertThat(updatedUser.name).isEqualTo("")
    }

    @Test
    fun `test sequence of actions`() {

        val clientMock: UserClient = mockk(relaxed = true)
        val repoMock: UserRepository = mockk()
        val user = User(1, "Bob")

        verifySequence {
            clientMock.getUser(2)
            repoMock.saveUser(user)
        }
    }
}

class UserUpdater(val userClient: UserClient) {
    fun updateUser(user: User): User {
        return userClient.getUser(1)
    }
}

// final class, doesn't need to be opened to be mocked with mockk
class UserClient {
    fun getUser(id: Int): User {
        return User(id, null)
    }
}

class UserRepository {
    fun saveUser(user: User) {

    }
}

data class User(val id: Int, val name: String?)
