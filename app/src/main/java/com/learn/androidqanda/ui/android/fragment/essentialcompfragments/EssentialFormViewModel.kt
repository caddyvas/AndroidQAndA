package com.learn.androidqanda.ui.android.fragment.essentialcompfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EssentialFormViewModel : ViewModel() {
    // for approach 1
    var name: String = ""
    var email: String = ""
    var phone: String = ""
    var resultTextToDisplay: String = ""

    // for approach 3
    private val _resultText = MutableLiveData<String>("")
    val resultText: LiveData<String> = _resultText

    fun setResult(name: String) {
        _resultText.value = "HeLLO, $name"
    }
}