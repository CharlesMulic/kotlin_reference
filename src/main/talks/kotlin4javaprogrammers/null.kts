fun nickName(name: String): String? { // make return type nullable with String?
    if (name == "Robert") {
        return "Bob"
    }
    return null
}

println(nickName("Robert"))
println(nickName("Venkat"))

class Test(val left: Test?, val right: Test?)

val left = Test(null, null)
val right = Test(null, null)
val parent = Test(left, right)

println(parent.left)
println(parent.left?.left)
println(parent.left!!.left)

println(left.left ?: "nothing")
println(left.left?.left)
println(left.left!!.left) // throws NPE