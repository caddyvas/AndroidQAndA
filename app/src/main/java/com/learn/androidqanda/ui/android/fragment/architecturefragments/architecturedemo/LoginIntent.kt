package com.learn.androidqanda.ui.android.fragment.architecturefragments.architecturedemo

/**
 * Intent part of MVI
 * use sealed class for Type Safety + exhaustive pattern matching
 * Kotlin's sealed class gives compile-time guarantees that all possible intents are handled.
 */
sealed class LoginIntent {
    data class EnterUserName(val userName: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    object SubmitLogin : LoginIntent()
}