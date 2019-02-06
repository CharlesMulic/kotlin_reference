package demo

fun main(args: Array<String>) {
    val age = 8

    if (age < 5) {
        println("< 5")
    } else if (age == 5) {
        println("== 5")
    } else if ((age > 5) && (age < 17)) {

    } else {

    }

    when (age) {
        0,1,2,3,4 -> println(" matches 0..4 inclusive")
        5 -> println ("matches 5")
        in 6..17 -> {
            println("in range 6..17")
        }
        else -> println("else")
    }
}