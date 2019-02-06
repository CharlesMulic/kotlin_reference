package talks.exploringcoroutines

import java.lang.Exception

fun main() {
//    println(getCallerIP())
//    println(getStockPrice("GOOG"))

    val ticker = "GOOGGG"
    try {
        val price = getStockPrice(ticker)

        try {
            val ip = getCallerIP()
            println("Price for $ticker is $price, request from $ip")
        } catch (ex: Exception) {
            println("Error getting ip")
        }
    } catch (ex: Throwable) {
        println("Error getting price for $ticker")
        ex.printStackTrace()
    }
}

fun getCallerIP(): String {
    return java.net.URL("https://api.ipify.org").readText()
}

fun getStockPrice(ticker: String): String {
    return java.net.URL("https://api.iextrading.com/1.0/stock/$ticker/price").readText()
}