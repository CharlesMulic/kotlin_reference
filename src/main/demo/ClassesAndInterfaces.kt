package demo

fun main() {
    // no static methods
    // classes marked as final by default unless marked "open"

    val bowser = Animal("Bowser", 20.0, 13.5)
    bowser.getInfo()

    val doggo = Dog("Doggo", 2.0, 10.0, "Charlie")
    doggo.getInfo()

    val bird = Bird("Tweety", true)
    bird.fly(5.0)
}

// open class can be extended
open class Animal(val name: String, var height: Double, var weight: Double) {
    init {
        // like a constructor? not sure
        val regex = Regex(".*\\d+.*")
        require(!name.matches(regex)) { "Animal name can't contain numbers" }
        require(height > 0) { "Height must be greater than 0" }
        require(weight > 0) { "Weight must be greater than 0" }
    }

    // must be open if you want to be able to override
    open fun getInfo(): Unit {
        println("$name is $height tall and weights $weight")
    }
}

class Dog(name: String, height: Double, weight: Double, var owner: String) : Animal(name, height, weight) {
    override fun getInfo() {
        println("$name is $height tall and weights $weight and is owned by $owner")
    }
}

interface Flyable {
    var flies: Boolean
    fun fly(distMile: Double): Unit
}

class Bird(name: String, override var flies: Boolean = true): Animal(name, 1.0, 1.0), Flyable {
//class Bird constructor(name: String, override var flies: Boolean = true): Animal(name, 1.0, 1.0), Flyable {
//class Bird constructor(val name: String, override var flies: Boolean = true): Flyable {
    override fun fly(dist: Double) {
        if (flies) {
            println("$name flies $dist miles")
        }
    }

}