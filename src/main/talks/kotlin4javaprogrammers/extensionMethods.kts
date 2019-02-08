// extension methods can't be overloaded, just a convenience thing
fun String.shout() = toUpperCase()
fun String.pad(): String {
    return this.padStart(2, ' ').padEnd(2, ' ')
}

val greet = "hello"

println(greet.shout())
println(greet.pad())