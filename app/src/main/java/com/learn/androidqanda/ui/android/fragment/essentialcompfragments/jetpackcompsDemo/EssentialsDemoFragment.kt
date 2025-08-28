package com.learn.androidqanda.ui.android.fragment.essentialcompfragments.jetpackcompsDemo

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi


import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle

import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.learn.androidqanda.R
import com.learn.androidqanda.ui.android.fragment.essentialcompfragments.EssentialFormViewModel
import kotlinx.coroutines.launch

class EssentialsDemoFragment : Fragment(R.layout.fragment_essentials_demo) {

    private val viewModel: EssentialFormViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val liveText = view.findViewById<TextView>(R.id.liveDataCounterText)
        val flowText = view.findViewById<TextView>(R.id.flowCounterText)
        val eventText = view.findViewById<TextView>(R.id.eventText)
        val button = view.findViewById<Button>(R.id.incrementButton)
        val explanation = view.findViewById<TextView>(R.id.essential_demo_explanation)
        // LiveData observer
        viewModel.counterLiveData.observe(viewLifecycleOwner) {
            liveText.text = "LIVEDATA: $it"
        }

        // SingleLiveEvent observer
        viewModel.eventLiveData.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            eventText.text = message
        }

        // StateFlow collector
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.counterStateFlow.collect {
                    flowText.text = "STATEFLOW: $it"
                }
            }
        }

        // SharedFlow collector
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventSharedFlow.collect { message ->
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                    eventText.text = message
                }
            }
        }

        button.setOnClickListener {
            viewModel.increment()
        }

        explanation.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        explanation.text = resources.getText(R.string.essentials_demo_explanation)
    }
}