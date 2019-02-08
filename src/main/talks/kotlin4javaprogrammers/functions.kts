val age = 17
val canVote = if (age > 17) "please vote" else "not so fast" // if is an expression
println(canVote)

fun greet(name: String, msg: String = "hi") = "$msg $name" // = says do type inference and determine return type
fun greet2(name: String, msg: String): String {
    return "$msg $name"
}

println(greet("Jane", "hello"))
println(greet("Jerry"))
println(greet(msg = "Howdy", name = "Sara"))
println(greet("Sara", msg = "Hello"))

fun max(vararg numbers: Int) = numbers.reduce { max, e -> if(max > e) max else e }
println(max(1,2))
println(max(7,3,9,4))

val values = intArrayOf(4,5,23,2)
//println(max(values)) // can't pass int array type
println(max(1, 2, 3, *values, 9, 2)) // can use the spread operator