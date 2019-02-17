package game

import java.awt.Dimension
import javax.swing.JFrame
import java.awt.Toolkit
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent

class JFrameGameWindow : GameWindowImplementation {

    override fun onWindowEvent(handler: (GameWindowEvent) -> Unit) {
        windowEventHandler = handler
    }

    private val frame: JFrame = JFrame()

    init {
        frame.setResizable(false)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    override fun setTitle(title: String) {
        frame.title = title
    }

    override fun setSize(width: Int, height: Int) {
        frame.size = Dimension(width, height)
        val dim = Toolkit.getDefaultToolkit().getScreenSize()
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2)
    }

    companion object {
        private var windowEventHandler: ((GameWindowEvent) -> Unit) = {}

        val mouseAdapter = object : MouseAdapter() {
            override fun mouseMoved(e: MouseEvent) {
                windowEventHandler(MouseMoved(e.x, e.y))
            }

            override fun mousePressed(e: MouseEvent) {
                windowEventHandler(MousePressed(e.x, e.y, e.button))
            }

            override fun mouseReleased(e: MouseEvent) {
                windowEventHandler(MouseReleased(e.x, e.y, e.button))
            }

            override fun mouseWheelMoved(e: MouseWheelEvent) {}
            override fun mouseEntered(e: MouseEvent) {}
            override fun mouseExited(e: MouseEvent) {}
        }
    }

    override fun show() {
        frame.setVisible(true)
        frame.addMouseListener(mouseAdapter)
        frame.addMouseMotionListener(mouseAdapter)
        frame.addMouseWheelListener(mouseAdapter)
    }
}

data class MouseMoved(val x: Int, val y: Int) : GameWindowEvent()

open class BaseMouseEvent(
    val x: Int,
    val y: Int,
    val button: Int,
    val timestamp: Long = System.nanoTime()
) : GameWindowEvent() {
    override fun toString(): String {
        return "${this.javaClass.simpleName}(x=$x, y=$y, button=$button, timestamp=$timestamp)"
    }
}

class MouseReleased(x: Int, y: Int, button: Int) : BaseMouseEvent(x, y, button)
class MousePressed(x: Int, y: Int, button: Int) : BaseMouseEvent(x, y, button)