val double = { e: Int -> e * 2 }

listOf(1, 2, 3, 4, 5, 6)
    .filter { e -> e % 2 == 0 }
    .map(double)
    .forEach { println(it) }
//    .forEach { e -> println(e) }