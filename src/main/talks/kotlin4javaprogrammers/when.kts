fun process(input: Any) {
    when (input) {
        1 -> println("You got one")
        7, 8 -> println("You got 7 or 8")
        in 12..19 -> println("teen")
        is String -> println("You got ${input}")
        else -> println("Whatever")
    }
}

process(1)
process(8)
process(16)
process("Hello")