package demo

fun main() {
    val map = mutableMapOf<Int, Any?>()

    val map2 = mutableMapOf(1 to "Doug", 2 to 25)

    map[1] = "Derek"
    map[2] = 42

    println(map)
    println(map2)
    println("Map Size: ${map.size}")

    map.remove(2)

    for((x,y) in map) {
        println("key: $x, value: $y")
    }
}