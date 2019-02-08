fun compute(n: Int): Int {
    println("called")
    return n
}

val x = 4
//val temp = compute(4) // calls compute even though we don't need it
val temp by lazy { compute(4) } // lazy -- won't be called unless it is needed
//if (x > 5 && compute(4) > 7) { // knows to not call compute
if (x > 5 && temp > 7) {
    println("result")
}