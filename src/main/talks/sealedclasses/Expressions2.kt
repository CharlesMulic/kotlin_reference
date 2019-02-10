package talks.sealedclasses.two

import java.lang.RuntimeException

interface Expression {
    fun <R> accept(visitor: ExpressionVisitor<R>): R
}

class Constant(val value: Double) : Expression {
    override fun <R> accept(visitor: ExpressionVisitor<R>): R = visitor.visit(this)
}

class Binary(val left: Expression, val operator: String, val right: Expression) : Expression {
    override fun <R> accept(visitor: ExpressionVisitor<R>): R = visitor.visit(this)
}

// overloading vs overriding
// static dispatch vs dynamic dispatch
interface ExpressionVisitor<out R> {
    fun visit(self: Constant): R
    fun visit(self: Binary): R
}

class LispTreeGenerator : ExpressionVisitor<String> {
    override fun visit(self: Constant) = self.value.toString()

    override fun visit(self: Binary) =
        "(${self.left.accept(this)} ${self.operator} ${self.right.accept(this)})"
}

class Evaluator : ExpressionVisitor<Double> {
    override fun visit(self: Constant) = self.value

    override fun visit(self: Binary): Double {
        val a = self.left.accept(this)
        val b = self.right.accept(this)
        return when (self.operator) {
            "+" -> a + b
            "*" -> a * b
            else -> throw RuntimeException("Unhandled operator: ${self.operator}")
        }
    }
}

fun main() {
    val example = Binary(Constant(2.0), "+", Binary(Constant(3.0), "*", Constant(4.0)))
//    println(lispTree(example))
    println(example.accept(LispTreeGenerator()))
    println(example.accept(Evaluator()))
}


