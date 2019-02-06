package demo

// data class seems to provide some functionality like @Data in lombok, toString() for ex

data class Address(val street: String, val city: String, val state: String, val zip: Int)
data class Occupation(val title: String, val income: Double)
data class Person(val firstName: String, val lastName: String, val address: Address, val occupation: Occupation?)

fun main(args: Array<String>) {
    val person = Person(
        "Charlie",
        "Mulic",
        Address("9464 Jewel Lane N", "Maple Grove", "MN", 55311),
        null)

    println(person)
    sayHello(person)
}

fun sayHello(person: Person) {
    println("Hello, ${person.firstName} ${person.lastName}")
}
