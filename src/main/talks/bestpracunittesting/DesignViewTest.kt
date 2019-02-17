package talks.bestpracunittesting

import io.mockk.clearMocks
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DesignViewTest {

    private val repo: DesignRepository = mockk()
    private lateinit var view: DesignView // stateful

    @BeforeEach
    fun init() {
        clearMocks(repo)
        view = DesignView(repo) // recreation required
    }

    @Test
    fun changeButton() {
        assertThat(view.button.caption).isEqualTo("Hi")
        view.changeButton()
        assertThat(view.button.caption).isEqualTo("Guten Tag")
    }
}

data class DesignView(val repo: DesignRepository, val button: Button = Button("Hi")) {
    fun changeButton() {
        button.caption = "Guten Tag"
    }
}

data class Button(var caption: String)
