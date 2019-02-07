package demo

fun main() {
    // by default you can't assign null
//    var nullVal: String = null // can't do this
    var nullVal: String? = null // String? explicitly indicates nullable

    fun returnNull(): String? { // have to explicitly indicate potential null return values
        return null
    }

    var nullVal2 = returnNull()
    if (nullVal2 != null) {
        println(nullVal2.length)
    }
    println(nullVal2?.length)
//    println(nullVal2.length) // this doesn't compile because the type can be null

    var nullVal4: String = returnNull() ?: "No Name"
    println(nullVal4)

    var nullVal3 = nullVal2!!.length // force check on nullable type, throws NPE
}