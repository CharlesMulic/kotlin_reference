class User()

//val user: User? = null
var user: User? = null

if (user != null) {
    // user not null if val
    // user might be null if var
}

user?.let {
    // in here user is guaranteed not to be null
}

class Foo {
    // writing code that is concurrent, dealing with volatiles, volatile reads/writes are expensive
    @Volatile
    var user: User? = null

    fun doSomething() {
        user?.let { user ->
            // user not null, only read once
        }

        // similar, subtle differences
//        user?.apply {}
//        user?.run {}
//        user?.also {}
    }
}

fun someMethod() = true

someMethod().let { result ->
    // can use result multiple times without declaring a local variable
}