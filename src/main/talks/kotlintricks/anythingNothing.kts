import java.lang.IllegalArgumentException
import java.net.ServerSocket
import java.net.Socket

// in Java all types derive from Object
// in Kotlin, similar is Any
// additional type is Nothing

class User(val name: String?)

fun printName(user: User?) {
    val name = user?.name ?: throw IllegalArgumentException("User was null")
    println("Name is $name")
}

fun runServer(serverSocket:ServerSocket): Nothing {
    while(true) {
        handleSocket(serverSocket.accept())
    }
}

fun startServer() {
    runServer(ServerSocket(80))
    println("running") // unreachable code, never run because runServer returns Nothing?
}

fun handleSocket(accept: Socket?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
