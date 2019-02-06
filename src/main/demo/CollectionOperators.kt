package demo

fun main() {
    val numList = 1..20

    // summation
    val listSum = numList.reduce { x, y -> x + y }
    println(listSum)

    // summation with initial value
    val listFold = numList.fold(5) { x, y -> x + y }
    println(listFold)

    // anything in list matches condition
    println(numList.any { it == 20 })
    println(numList.any { it == 0 })

    val evenList = listOf(2,4,6,8,10)
    println(numList.all { it % 2 == 0 }) // not all items in this list are even, false
    println(evenList.all { it % 2 == 0 }) // all items in this list are even, true

    val biggerThan3 = numList.filter { it > 3 }
    println(biggerThan3)

    val times7 = numList.map { it * 7 } // map each element to new list with function applied
    println(times7)
}