package budget

fun main() {
    val budget = Budget(
        listOf(
            BudgetItem("Mortgage", 500.0),
            BudgetItem("Cell Phone", 25.0),
            BudgetItem("Internet", 50.0)
        )
    )
    val user = User("someone@gmail.com", "password", budget)

    println(budget.monthlyExpenses())
}

class User(val email: String, var password: String, val budget: Budget)
class Budget(val budgetItems: List<BudgetItem>) {
    fun monthlyExpenses() = budgetItems.map { it.cost }.reduce { total, cost -> total + cost}
}
class BudgetItem(val name: String, val cost: Double, val recurrence: Recurrence = Recurrence.MONTHLY)
class BudgetItemDetails(val description: String, val url: String, val notes: String)
enum class Recurrence { DAILY, WEEKLY, BIWEEKLY, MONTHLY, YEARLY }
enum class CostType { FIXED, VARIABLE }