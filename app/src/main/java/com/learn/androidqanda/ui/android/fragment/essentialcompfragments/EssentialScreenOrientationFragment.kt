package com.learn.androidqanda.ui.android.fragment.essentialcompfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.learn.androidqanda.databinding.FragmentEssentialsScreenorientationBinding

class EssentialScreenOrientationFragment : Fragment() {

    private var _binding: FragmentEssentialsScreenorientationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EssentialFormViewModel by viewModels()

    private var isApproachTwoActive = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEssentialsScreenorientationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //screenOrientationChangeHandleApproachOne()
        screenOrientationChangeHandleApproachTwo(savedInstanceState)
        //screenOrientationChangeHandleApproachThree()
    }

    // Approach 1 using viewmodel
    private fun screenOrientationChangeHandleApproachOne() {
        // restore values into EditTexts
        binding.editTextName.setText(viewModel.name)
        binding.editTextEmail.setText(viewModel.email)
        binding.editTextPhone.setText(viewModel.phone)
        binding.textViewResult.text = viewModel.resultTextToDisplay

        // keep viewModel updated when user types
        binding.editTextName.doOnTextChanged { text, _, _, _ ->
            viewModel.name = text.toString()
        }

        // keep viewModel updated when user types
        binding.editTextEmail.doOnTextChanged { text, _, _, _ ->
            viewModel.email = text.toString()
        }

        // keep viewModel updated when user types
        binding.editTextPhone.doOnTextChanged { text, _, _, _ ->
            viewModel.phone = text.toString()
        }
        // submit button click
        binding.buttonSubmit.setOnClickListener {
            viewModel.resultTextToDisplay = "HELLO, ${viewModel.name}"
            binding.textViewResult.text = viewModel.resultTextToDisplay
        }
    }

    // approach 2 using onSaveInstanceState
    private fun screenOrientationChangeHandleApproachTwo(savedInstanceState: Bundle?) {
        isApproachTwoActive = true
        // restore after rotation
        savedInstanceState?.let {
            binding.textViewResult.text = it.getString("result_text", "")
        }

        binding.buttonSubmit.setOnClickListener {
            binding.textViewResult.text = "HELLO, ${binding.editTextName.text}"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (isApproachTwoActive) {
            outState.putString("result_text", binding.textViewResult.text.toString())
        }
    }

    // approach 3 - Using ViewModel + LiveData, if you want automatic updates without manually setting the textview
    private fun screenOrientationChangeHandleApproachThree() {
        viewModel.resultText.observe(viewLifecycleOwner) { text ->
            binding.textViewResult.text = text
        }

        binding.buttonSubmit.setOnClickListener {
            viewModel.setResult(binding.editTextName.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}