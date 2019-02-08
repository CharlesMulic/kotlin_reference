//val greet : String = "hello"
val greet = "hello" // inferred type String
println(greet)
println(greet.javaClass)

val number = 4
println(number)
//number = 4 // can not be reassigned, val == final, readonly, immutable

var number1 = 4
println(number1)
//number1 = "4" // can't assign, inferred type is Int

println("Stuff in a string: ${number + number1}")

val name = "Bob"
val msg = """This is a message
    |written on and send to $name
""".trimMargin()
println(msg)