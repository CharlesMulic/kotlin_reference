package talks.exploringcoroutines

fun main() {
    seq()
}

// write a method, marked as suspending the call and go off and execute in different thread, asynchronously
// continuations, context to continue from
fun seq() {
//    val sequence = buildSequence {
    val sequence = sequence {
        println("one")
        yield(1) // function returns this value and the context to resume the sequence execution

        println("two")
        yield(2) // function returns this value and the context to resume the sequence execution

        println("three")
        yield(3) // function returns this value and the context to resume the sequence execution

        println("done") // end of function, nothing more in the sequence
    }

    for (value in sequence) {
        println(value)
    }
}