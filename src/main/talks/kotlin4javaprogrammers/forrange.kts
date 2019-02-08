
for (x in 1..10) { // inclusive
//for (x in 1 until 10) { // exclusive
//for(x in 1..10 step 2) { // increment by 2 each iteration
//for (x in 10 downTo 1) {
//for (x in 10 downTo 1 step 2) {
    println(x)
}

val names = listOf("Tom", "Jerry", "Spike")

for (name in names) {
    println(name)
}

for (index in names.indices) {
    println("$index ${names[index]}")
}