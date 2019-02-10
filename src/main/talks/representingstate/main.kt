package talks.representingstate

import java.util.concurrent.TimeUnit

fun main() {
    println("test")

    val one = true to true // Pair type
    val tuple = Tuple(true, true, true)
    println(tuple)
}

data class Tuple<T>(val first: T, val second: T, val third: T)


// bound types
enum class Endpoint(private val endPt: String) {
    Production("/pinterest/v1"),
    Testin("/pintertest/test");

    fun getUrl() = "$baseUrl$endPt"

    private companion object {
        private const val baseUrl = "www.something.com"
    }
}

// usage
class MyNetworkingLayer {
    val improvedEndpoint = Endpoint.Production

    fun useInNetweorkRequest() {
        improvedEndpoint.getUrl()
    }
}

// bad
//interface PrefetchPolicy {
//    val size: Int
//    val frequency: Int
//}

// better
interface PrefetchPolicy {
    val size: PrefetchSize
    val frequency: PrefetchFrequency
}

enum class PrefetchSize(val pagesToFetch: Int) {
    DataConstrained(1),
    Network(2),
    WiFi(3),
}

enum class PrefetchFrequency(val timeInMillis: Long) {
    Hourly(TimeUnit.HOURS.toMillis(1)),
    Daily(TimeUnit.DAYS.toMillis(1))
}