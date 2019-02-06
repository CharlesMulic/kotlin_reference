package demo

fun main(args: Array<String>) {
    println("Hello world!")

    // inferred types
    val name = "Charlie" // readonly, immutable variable
    var age = 33 // mutable variable

    // declared types
    val bigInt: Int = Int.MAX_VALUE;
    val smallInt: Int = Int.MIN_VALUE;

    // String interpolation like Groovy
    println("Biggest Int: ${bigInt}")
    println("Smallest Int: $smallInt")

    // Long, Double, Float, Boolean, Short, Byte, Char

    if (true is Boolean) { // typeof, instanceof check?
        println("test")
    }

    val character: Char = 'A'
    println("character is Char: ${character is Char}")

    println(3.14.toInt())
    println(3.toFloat())

    val longStr = """blah
        |gjgjg
        |dsjsd
        |sds
    """.trimMargin() // seems to get rid of whitespace up to and including |
    println(longStr.length)

    val str1 = "blah"
    val str2 = "blah"
    println("$str1 equals $str2: ${str1.equals(str2)}")
    println("$str1 equals $str2: ${str1.compareTo(str2)}")
    println("2nd index: ${str1.get(2)}")
    println("2nd index: ${str1[2]}")
    println("substring: ${str1.subSequence(2,4)}")
    println("contains bl: ${str1.contains("bl")}")
}