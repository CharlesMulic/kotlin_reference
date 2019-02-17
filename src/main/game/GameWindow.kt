package game

fun main() {
    val window = GameWindow(windowImplementation = JFrameGameWindow())
    window.create(GameWindowConfiguration(1024, 768))
    window.on { event ->
        when(event) {
            is MouseMoved -> println(event)
            is MousePressed -> println(event)
            is MouseReleased -> println(event)
            else -> println(event)
        }
    }
    window.show()
}

abstract class GameWindowEvent

interface GameWindowImplementation {
    fun show()
    fun setTitle(title: String)
    fun setSize(width: Int, height: Int)
    fun onWindowEvent(handler: (GameWindowEvent) -> Unit)
}

data class GameWindowConfiguration(val width: Int = 1024, val height: Int = 768, val title: String = "Game Window")

class GameWindow(val windowImplementation: GameWindowImplementation) {
    fun show() {
        windowImplementation.show()
    }

    fun create(configuration: GameWindowConfiguration) {
        windowImplementation.setSize(configuration.width, configuration.height)
        windowImplementation.setTitle(configuration.title)
    }

    fun on(handler: (GameWindowEvent) -> Unit) {
        windowImplementation.onWindowEvent(handler)
    }

}