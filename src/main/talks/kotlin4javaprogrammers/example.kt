package talks.kotlin4javaprogrammers

fun main(args: Array<String>) {
//    val msg = if (args.size > 0) args[0] else "Test"
//    val msg = if (args.isNotEmpty()) args.first() else "Test"
    val msg = args.firstOrNull() ?: "Test"
    println("Hello $msg")
}