package typehierarchy

// https://www.youtube.com/watch?v=juFkdMv4B9s

// types in the compiler, classes in the virtual machine
// types relate to syntax, not runtime

// types help you avoid common runtime errors
fun main() {
    val boolean: Boolean = false
    val byte: Byte = 1
    val char: Char = 'a'
    val int: Int = 1
    val long: Long = 1
    val float: Float = 1.0f
    val double: Double = 1.0
    val string: String = "test"
    val fn: (Int) -> Int = fun(a: Int): Int { return a * 2 } // function type
//    val fn = { a: Int -> a * 2 }

    val any: Any = fn // root of hierarchy, like java.lang.Object, but not nullable
    val nothing: Nothing? = null
    val unit: Unit = Unit // analogous to void

//    val array: Array<Int> = Array(1,{ i -> i })
//    val array: Array<Int> = arrayOf(1,2,3)
}

data class DataClass(val data: String)
enum class EnumClass(private val value: Int) { ONE(1) }

interface MyInterface<in J, out K> { // interfaces are subtypes of Any, can define output generics
    fun hello(name: J): K
}

class MyClass : MyInterface<String, String> {
    override fun hello(name: String): String {
        return "hello $name"
    }

}