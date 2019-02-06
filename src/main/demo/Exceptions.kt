package demo

import java.lang.IllegalArgumentException

fun main() {
    val divisor = 0

    try {
        if (divisor == 0) {
            throw IllegalArgumentException("Can't divide by Zero")
        } else {
            println("5 / $divisor = ${5 / divisor}")
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}