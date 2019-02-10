package talks.sealedclasses

fun main() {
    val spool = getYarn()
    val yarn = when (spool) {
        is Yarn.Cotton -> knit()
        is Yarn.Silk -> TODO()
        is Wool.Merino -> TODO()
        is Wool.Alpaca -> TODO()
    }

    val yarnStash: Sequence<Yarn> = listOf(
        Yarn.Cotton(),
        Wool.Merino(),
        Wool.Alpaca(),
        Yarn.Silk()
    ).asSequence()

    val warmWool = yarnStash.filterIsInstance<Wool>()
    warmWool.forEach {
        val yarn = when (it) {
            is Wool.Merino -> TODO()
            is Wool.Alpaca -> TODO()
        }
    }
}

sealed class Yarn {
    class Cotton: Yarn()
    class Silk: Yarn()
//    sealed class Wool: Yarn() {
//        class Merino: Wool()
//        class Alpaca: Wool()
//    }
}

sealed class Wool: Yarn() {
    class Merino: Wool()
    class Alpaca: Wool()
}

fun knit() {

}

val yarns = listOf(
    Yarn.Cotton(),
    Yarn.Silk(),
    Wool.Merino(),
    Wool.Alpaca()
)

fun getYarn() = yarns.random()