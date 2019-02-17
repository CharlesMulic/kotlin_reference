package functionalarrow

fun main() {
    val test = listOf("one", "two", "two", "one", "one")
    val grouped = test.groupBy { it }
    println(grouped)

    println(countOccurrencesInList(test))
}

fun <T> countOccurrencesInList(elements: List<T>): List<Pair<T, Int>> =
    elements.groupBy { it }.map { Pair(it.key, it.value.count()) }