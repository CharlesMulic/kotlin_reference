package talks.sealedclasses

fun main() {

}

sealed class SocialSignInResult {
    data class Success(val token: String) : SocialSignInResult()
    data class Link(val token: String) : SocialSignInResult()
    data class Register(val token: String) : SocialSignInResult()
    data class Error(val errorMessage: String) : SocialSignInResult()
}

sealed class SignInResult {
    data class Success(val token: String) : SignInResult()
    data class TwoFactorAuth(val token: String) : SignInResult()
    data class Fail(val token: String) : SignInResult()
    data class RetrySocial(val errorMessage: String) : SignInResult()
}

sealed class TwoFAResult {
    object Success : TwoFAResult()
    data class Retry2FA(val token: String) : TwoFAResult()
    data class Fail(val errorMessage: String) : TwoFAResult()
    data class RetrySocial(val errorMessage: String) : TwoFAResult()
}