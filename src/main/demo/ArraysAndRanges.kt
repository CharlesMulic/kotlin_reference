package demo

fun main(args: Array<String>) {
    val myArray = arrayOf(1, 1.23, "Charlie") // array of multiple types

    println(myArray)
    println(myArray is Array)
    println(myArray[1])
    myArray[1] = 3.21
    println(myArray[1])
    println(myArray.get(2))
    println(myArray.size)
    println(myArray.contains("Charlie"))

    val partArray = myArray.copyOfRange(0, 2)
    println(partArray.first())
    println(partArray.last())
    println(partArray.indexOf(3.21))

    val sqArray = Array(5, { x -> x * x } )
    println("${sqArray[0]} ${sqArray[1]} ${sqArray[2]} ${sqArray[3]} ")

    val arr2: Array<Int> = arrayOf(1,2,3)
//    arr2[0] = 1.2 // typed

    // Ranges
    val oneTo10 = 1..10
    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val alpha = "A".."Z"

    println("R in alpha: ${"R" in alpha}")

    val rng3 = oneTo10.step(3)

    for (x in rng3) {
      println(x)
    }

    for (x in tenTo1.reversed()) {
        print("$x ")
    }
    println()
}