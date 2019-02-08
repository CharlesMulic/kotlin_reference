package budget

fun main() {
    val budget = Budget(
        listOf(
            BudgetItem("Mortgage", 777.05),
            BudgetItem("Association", 247.0),
            BudgetItem("Cell Phone", 25.0),
            BudgetItem("Internet", 50.0),
            BudgetItem("Car Insurance", 66.67),
            BudgetItem("Electricity", 75.0),
            BudgetItem("Gas", 30.0),
            BudgetItem("Food", 300.0),
            BudgetItem("Household", 20.0),
            BudgetItem("Leisure", 100.0),
            BudgetItem("Clothes", 50.0),
            BudgetItem("Contingency", 200.0)
        )
    )
    val user = User("charles.mulic@gmail.com", "password", budget)

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