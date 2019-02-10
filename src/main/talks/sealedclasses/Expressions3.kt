package talks.sealedclasses.three

// https://www.youtube.com/watch?v=4qLj-kSOZLQ

sealed class Expression
class Constant(val value: Double) : Expression()
class Binary(val left: Expression, val operator: String, val right: Expression) : Expression()

fun Expression.lispTree(): String = when (this) {
    is Constant -> value.toString()
    is Binary -> "(${left.lispTree()} $operator ${right.lispTree()})"
}

fun Expression.evaluate(): Double = when (this) {
    is Constant -> value
    is Binary -> {
        val a = left.evaluate()
        val b = right.evaluate()

        when (operator) {
            "+" -> a + b
            "*" -> a * b
            else -> error(operator)
        }
    }
}

fun main() {
    val example = Binary(Constant(2.0), "+", Binary(Constant(3.0), "*", Constant(4.0)))
    println(example.lispTree())
    println(example.evaluate())
}


/*
//fun lispTree(self: Expression): String {
fun Expression.lispTree(): String {
    return when (this) {
        is Constant -> value.toString()
        is Binary -> "(${left.lispTree()} $operator ${right.lispTree()})"
    }
}

//fun evaluate(self: Expression): Double {
fun Expression.evaluate(): Double {
    return when (this) {
        is Constant -> value
        is Binary -> {
            val a = left.evaluate()
            val b = right.evaluate()

            return when (operator) {
                "+" -> a + b
                "*" -> a * b
                else -> error(operator)
            }
        }
    }
}
 */