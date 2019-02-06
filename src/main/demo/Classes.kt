package demo

fun main() {
    // no static methods
    // classes marked as final by default unless marked "open"

    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()
}

// open class can be extended
open class Animal(val name: String, var height: Double, var weight: Double) {
    init {
        // like a constructor? not sure
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) { "Animal name can't contain numbers" }
        require(height > 0) { "Height must be greater than 0"}
        require(weight > 0) { "Weight must be greater than 0"}
    }

    // must be open if you want to be able to override
    open fun getInfo(): Unit {
        println("$name is $height tall and weights $weight")
    }
}