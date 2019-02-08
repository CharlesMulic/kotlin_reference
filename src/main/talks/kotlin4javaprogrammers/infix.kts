class Pizza {
    infix fun spread(item:String) {
        println("spread $item")
    }
}

val pizza = Pizza()

pizza spread "Cheese" // infix allows this sort of syntax for single arg methods