package com.learn.androidqanda.ui.android.fragment.titbitsfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _data = MutableLiveData<String>()
    val data: LiveData<String> = _data

    fun sendData(value: String) {
        _data.value = value
    }
}