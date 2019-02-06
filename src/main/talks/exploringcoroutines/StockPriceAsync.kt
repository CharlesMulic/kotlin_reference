package talks.exploringcoroutines.async

import kotlinx.coroutines.*

// https://www.youtube.com/watch?v=jT2gHPQ4Z1Q
fun main() {
//    GlobalScope.launch {
//        val ticker = "GOOG"
//        try {
//            val price = getStockPrice(ticker)
//
//            try {
//                val ip = getCallerIP()
//                println("Price for $ticker is $price, request from $ip")
//            } catch (ex: Exception) {
//                println("Error getting ip")
//            }
//        } catch (ex: Exception) {
//            println("Error getting price for $ticker")
//            ex.printStackTrace()
//        }
//    }
//
//    println("request sent")
//    Thread.sleep(5000)

    val tickers = listOf("GOOG", "AMZN", "MSFT", "EGHT", "F")

    GlobalScope.launch {
        measureTime {
            //            val prices = mutableListOf<String>()
            val prices = mutableListOf<Deferred<String>>()

            for (ticker in tickers) {
//                prices += "Price for $ticker is ${getStockPrice(ticker)}"

                // run but come back with the result later on, returns a deferred value
                prices += async { "Price for $ticker is ${getStockPrice(ticker)}" }
            }

            for (price in prices) {
//                println(price)
                println(price.await())
            }
        }
    }
    Thread.sleep(5000)
}

// suspend functions automatically get passed a continuation parameter in the compiled class
suspend fun getCallerIP(): String {
    return java.net.URL("https://api.ipify.org").readText()
}

fun getStockPrice(ticker: String): String {
//suspend fun getStockPrice(ticker: String): String {
    return java.net.URL("https://api.iextrading.com/1.0/stock/$ticker/price").readText()
}

suspend fun measureTime(block: suspend () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end - start / 1.0e9)} seconds")
}

