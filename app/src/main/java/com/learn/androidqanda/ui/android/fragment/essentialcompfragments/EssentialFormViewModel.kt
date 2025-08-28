package com.learn.androidqanda.ui.android.fragment.essentialcompfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.androidqanda.ui.android.fragment.essentialcompfragments.jetpackcompsDemo.SingleLiveEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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

    // LiveData state
    private val _counterLiveData = MutableLiveData(0)
    val counterLiveData: LiveData<Int> = _counterLiveData

    // LiveData event
    private val _eventLiveData = SingleLiveEvent<String>()
    val eventLiveData: LiveData<String> = _eventLiveData

    // StateFlow state
    private val _counterStateFlow = MutableStateFlow(0)
    val counterStateFlow: StateFlow<Int> = _counterStateFlow.asStateFlow()

    // SharedFlow event
    private val _eventSharedFlow = MutableSharedFlow<String>()
    val eventSharedFlow: SharedFlow<String> = _eventSharedFlow.asSharedFlow()

    /**
     * LiveData and StateFlow counters update and display
     * on every multiple of 3, both singleLiveEvent and SharedFlow trigger a message
     * For the above line, toast and message text get updated
     */
    fun increment() {
        // livedata update
        val liveCounter = (_counterLiveData.value ?: 0) + 1
        _counterLiveData.value = liveCounter

        // stateflow update
        val flowCounter = _counterStateFlow.value + 1
        _counterStateFlow.value = flowCounter

        // liveDataEvent plus sharedflow
        if (flowCounter % 3 == 0) {
            _eventLiveData.value = "LiveData: Multiple of 3!"
            viewModelScope.launch {
                _eventSharedFlow.emit("SharedFlow: Multiple of 3!")
            }
        }
    }
}