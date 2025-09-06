package com.learn.androidqanda.ui.android.fragment.architecturefragments.architecturedemo

data class LoginState(
    val userName: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: String? = null
)