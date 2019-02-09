import java.util.concurrent.Callable

class Test : Callable<String> {

    fun something() = false

    fun doSomething() = "Doing something"

    override fun call(): String {
        if (something()) {
            return doSomething()
        } else {
            // TODO is actually a method that will throw NotImplementedError
            TODO("doSomethingElse()?")
        }
    }
}

val test = Test()
println(test.call())