package talks.bestpracunittesting.controller

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserControllerTest {
    private val repo: UserRepository = mockk()
    private val controller = UserController(repo)

    @Test
    fun `find user with correct values`() {
        every { repo.findUser(1) } returns User(1, "Peter")
        val user = controller.getUser(1)
        assertThat(user).isEqualTo(User(1, "Peter"))
    }
}

class UserRepository {
    fun findUser(id: Int): User =TODO("not implemented")
}

class UserController(val repo: UserRepository) {
    fun getUser(id: Int): User {
        return repo.findUser(id)
    }

}

data class User(val id: Int, val name: String)

//class UserControllerTest {
//    companion object {
//
//        @JvmStatic lateinit var controller: UserController
//        @JvmStatic lateinit var repo: UserRepository
//
////         initialize() {
////            repo = mock()
////            controller = UserController(repo)
////        }
//    }
//
//    @Test
//    fun findUser_UserFoundAndHasCorrectValues() {
//        `when`(repo.findUser(1)).thenReturn(User(1, "Peter"))
//        val user = controller.getUser(1)
//        assertEquals(user?.name, "Peter")
//    }
//}
//
//class UserController {
//    fun getUser(id: Int): User {
//        return User(id, "Peter")
//    }
//}
//
//data class User(val id: Int, val name: String)
