import java.lang.RuntimeException

// classes are final by default, can not inherit unless explicitly declared as open
class Car {
    var yearOfRegistration = 2010 // property, not a field
        set(value) {
            if (value > 2017) {
                throw RuntimeException("Not in the future")
            }
            field = value
        }

    fun drive() {
        println("driving")
    }

    // companion object can think of as like a holder of static methods?
//    companion object { // anonymous
    companion object CarKind { // declared
        fun kind() {
            println("kind called...")
        }
    }
}

val car = Car() // no new, can treat classes like functions
car.yearOfRegistration = 2016
//car.yearOfRegistration = 2019 // throws exception
println(car.yearOfRegistration)
println(car.drive())
println(Car.kind())
//println(Car.CarKind.kind()) // if declared
//println(Car.Companion.kind()) // if anonymous

// static methods?
object Util {
    fun getNumberOfCores() = 4
}

println(Util.getNumberOfCores())

data class Test(val data: String) // data class becomes immutable, can create copy, tostring, hash, etc, kind of like Lombok?