package com.learn.androidqanda.ui.android.fragment.architecturefragments.architecturedemo

import kotlinx.coroutines.delay

class LoginRepository {
    // In real, replace the mock call with Retrofit
    suspend fun login(userName: String, password: String): Boolean {
        delay(1500)
        return userName == "deepak" && password == "password"
    }
}