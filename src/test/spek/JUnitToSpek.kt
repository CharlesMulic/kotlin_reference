package spek

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

// https://www.youtube.com/watch?v=R425cc6XrvA
object JUnitToSpek : Spek({

    val scopeManager by memoized { MockScopeManager() }
    val accessTokenRepository by memoized { AccessTokenRepository(scopeManager) }

    describe("remove access token") {
        beforeEachTest {
            accessTokenRepository.removeAccessToken()
        }

        describe("first scope change") {
            val firstScopeChange by memoized {
                scopeManager.scopeChanges[0]
            }

            it("is 'logged in' scope") {
                assertThat(firstScopeChange.scope).isEqualTo(Scope.LOGGED_IN)
            }

            it("is not started") {
                assertThat(firstScopeChange.started).isFalse()
            }
        }

        describe("second scope change") {
            val secondScopeChange by memoized { scopeManager.scopeChanges[1] }

            it("is 'logged out' scope") {
                assertThat(secondScopeChange.scope).isEqualTo(Scope.LOGGED_OUT)
            }

            it("is started") {
                assertThat(secondScopeChange.started).isTrue()
            }
        }
    }

//    @Test
//    fun `remove access token should stop logged in scope and start logged out scope`() {
//        accessTokenRepository.removeAccessToken()
//
//        val scopeChange1 = scopeManager.scopeChanges[0]
//
//        assertThat(scopeChange1.scope).isEqualTo(PassengerScopes.LOGGED_IN)
//        assertThat(scopeChange1.started).isFalse()
//
//        val scopeChange2 = scopeManager.scopeChanges[1]
//
//        assertThat(scopeChange2.scope).isEqualTo(PassengerScopes.LOGGED_OUT)
//        assertThat(scopeChange2.started).isTrue()
//    }
})

enum class Scope { LOGGED_IN, LOGGED_OUT }

data class ScopeChange(val scope: Scope, val started: Boolean)

class MockScopeManager {
    var scopeChanges: List<ScopeChange> = emptyList()
}

class AccessTokenRepository(val scopeManager: MockScopeManager) {
    fun removeAccessToken() {
        scopeManager.scopeChanges = listOf(
            ScopeChange(Scope.LOGGED_IN, false),
            ScopeChange(Scope.LOGGED_OUT, true)
        )
    }
}

