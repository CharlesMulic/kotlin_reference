package demo

fun main(args: Array<String>) {
    fun add(num1: Int, num2: Int): Int = num1 + num2 // do not need return statement for single line functions
    fun subtract(num1: Int = 1, num2: Int = 1) =
        num1 - num2 // do not need return type for single line functions. inferred

    println(add(5, 4))
    println(subtract(5, 4))
    println(subtract()) // defaults to 1 - 1
    println(subtract(3)) // defaults to 3 - 1

    println(subtract(num2 = 5, num1 = 4)) // use named parameters

    fun sayHello(name: String): Unit = println("Hello $name") // Unit is like returning void
    sayHello("Charlie")

//    val pair = nextTwo(1) // returns a Pair
//    println(pair) // pair.first pair.second
    val (two, three) = nextTwo(1) // automatically decompose pair into its parts
    println("1 $two $three")

    println(getSum(1, 2, 3, 4))
    println(getSum(1, 2, 3, 4, 5, 6, 7))

    val multiply = { num1: Int, num2: Int -> num1 * num2 } // function literal
    println(multiply(5, 3))

    println(fact(5))
}

fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

// variable number of args
fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach { n -> sum += n }
    return sum
}

fun fact(x: Int): Int {
    tailrec fun factTail(y: Int, z: Int): Int {
        if (y == 0) {
            return z
        }
        return factTail(y - 1, y * z)
    }
    return factTail(x, 1)
}