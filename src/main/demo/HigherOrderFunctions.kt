package demo

fun main(args: Array<String>) {
    doFilter()
    doFunction()
}

fun doFilter() {
    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 }
    println(evenList)
}

fun doFunction() {
    val mult3 = makeMathFunc(3)
    println("5 * 3 = ${mult3(5)}")

    val multiply2 = { num1: Int -> num1 * 2 }
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2, multiply2) // passing a list and a function to call for each element of it
}

// function that returns that generates and returns a generated function
fun makeMathFunc(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }

fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
    for (num in numList) {
        println("MathOnList ${myFunc(num)}")
    }
}