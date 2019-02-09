package talks.kotlintricks

import java.util.*

// https://www.youtube.com/watch?v=0sPzDwS55wM

// extension functions
fun Date.isTuesday(): Boolean { return true }

fun main() {
    // nullability built into type system
    val firstName: String = "Jake"
    val lastName: String? = null

//    val firstName = "Jake" // type inference

    val user = User()
//    user = User() // error, immutable val

    var currentUser = User()
    currentUser = User() // ok, mutable var


//    if (Date.isTuesday()) println("It's Tuesday")
}

inline fun blah() {
    println("The body of this function will be inlined whever it is called")
}

// data gives you equals, hashcode, tostring for free
data class User(val firstName: String = "", val lastName: String = "")