class NamePrinter(val firstName: String, val lastName: String) {
//    val fullName : String by lazy { "$firstName $lastName" } // computation to assign fullName value deferred until called

    // disable overhead of locks if you know threading isn't an issue
    val fullName : String by lazy(LazyThreadSafetyMode.NONE) { "$firstName $lastName" } // computation to assign fullName value deferred until called

    // allows multiple threads to call lambda, but only use first to return
//    val fullName : String by lazy(LazyThreadSafetyMode.PUBLICATION) { "$firstName $lastName" } // computation to assign fullName value deferred until called

    fun printName() {
        println(fullName)
    }
}