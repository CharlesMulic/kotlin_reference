package talks.sealedclasses

interface Expression {
    fun evaluate(): Double
    fun listTree(): String
}

class Constant(val value: Double): Expression {
    override fun evaluate() = value
    override fun listTree() = "$value"
}

class Binary(val left: Expression, val operator: String, val right: Expression): Expression {
    override fun evaluate(): Double {
        val a = left.evaluate()
        val b = right.evaluate()
        return when(operator) {
            "+" -> a + b
            "*" -> a * b
            else -> throw RuntimeException("Unsupported operation: $operator")
        }
    }

    override fun listTree() = "(${left.listTree()} $operator ${right.listTree()})"
}

fun main() {
    val example = Binary(Constant(2.0), "+", Binary(Constant(3.0), "*", Constant(4.0)))
    println(example.listTree())
    println(example.evaluate())
}