package talks.bestpracunittesting

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

open class UserRepository

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
