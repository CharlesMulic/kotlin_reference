package talks.exploringcoroutines

import kotlinx.coroutines.*

fun main() {
    println(Thread.currentThread())
    println(process(2))
    GlobalScope.launch {
        println(process(2))
    }
    Thread.sleep(2000)
}

fun process(n: Int): Int {
    println("thread: ${Thread.currentThread()}")
    return n
}



