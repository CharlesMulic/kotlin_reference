
class Robot {
    val right = "Right"
    val left = "Left"

    infix fun turns(direction: String) {
        println("turns $direction")
    }
}

fun operate(func: (Robot) -> Unit) {
    println("called...")

    val robot = Robot()

    // run this code within the context of robot
    with(robot) {
        func(robot)
    }
}

operate {
    it turns "right"
    it turns "left"
//    it runs fast
}