package talks.sealedclasses

import java.lang.RuntimeException

/*
Sealed classes are used for representing restricted class hierarchies, when a value can have
one of the types from a limited set, but cannot have any other type.
They are, in a sense, an extension of enum classes: the set of values for an enum type is also restricted,
but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have
multiple instances which can contain state.
 */

fun main() {
    val result = getResult()
    val done = when (result) {
        is Result.Success -> showItems(result.items)
        is Result.Failure -> result.error.printStackTrace()
        is Result.Cancelled -> TODO()
        // no other possible types for result, so do not need an else clause
    }
}

sealed class Result {
    class Success(val items: List<String>) : Result()
    class Failure(val error: Throwable) : Result()
    object Cancelled: Result()
}

val results = listOf(
    Result.Success(listOf("Test")),
    Result.Failure(RuntimeException("Some Exception")),
    Result.Cancelled
)

fun getResult(): Result {
    return results.random()
}

fun showItems(items: List<String>) {
    println(items)
}