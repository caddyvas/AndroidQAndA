package com.learn.androidqanda.ui.android.fragment.architecturefragments.architecturedemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val repository = LoginRepository()

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EnterUserName -> _state.update { it.copy(userName = intent.userName) }
            is LoginIntent.EnterPassword -> _state.update { it.copy(password = intent.password) }
            is LoginIntent.SubmitLogin -> login()
        }
    }

    // put the business logic here
    private fun login() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null, successMessage = null) }

            val currentState = _state.value
            val result = repository.login(currentState.userName, currentState.password)

            _state.update {
                it.copy(
                    isLoading = false,
                    successMessage = if (result) "Login Successful" else null,
                    errorMessage = if (!result) "Invalid Credentials" else null
                )
            }
        }
    }
}