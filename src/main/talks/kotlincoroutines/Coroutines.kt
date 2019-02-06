package talks.kotlincoroutines

import kotlinx.coroutines.*
import java.nio.ByteBuffer

fun main() {
    println("calling blocking method")
    processImage()
    println("continuing after blocking  call")
    Thread.sleep(5000)
    println("main done")
}

fun processImage() = GlobalScope.async {
//    val image = loadImage("something.jpg")
//    setImage(image)

    val image = loadImageAsync("something.jpg").await()
    setImage(image)
}

fun setImage(image: ByteBuffer) {
    println("image set")
}

fun loadImage(url: String): ByteBuffer {
    println("image loading...")
    Thread.sleep(2000) // simulate network
    println("image loaded")
    return ByteBuffer.allocate(1028)
}

fun loadImageAsync(url: String): Deferred<ByteBuffer> = GlobalScope.async {
    println("image loading...")
    Thread.sleep(2000) // simulate network
    println("image loaded")
    return@async ByteBuffer.allocate(1028)
}