import talks.exploringcoroutines.async.measureTime

import kotlin.system.measureTimeMillis

fun stuff() {
    val helloTook = measureTimeMillis {
//    val helloTook = measureTime { // nano
        println("Hello, world")
    }

    println("Saying hello took $helloTook ms")
}

stuff()


