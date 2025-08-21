package com.learn.androidqanda.ui.android.fragment.titbitsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.learn.androidqanda.R

class TitBitsFragmentOne : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1_titbits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val editText = view.findViewById<EditText>(R.id.inputData)

        // For example, on button click
        view.findViewById<Button>(R.id.sendButton).setOnClickListener {
            val message: String = editText.text.toString()
            sharedViewModel.sendData(message)
        }

        // go to fragment3
        view.findViewById<Button>(R.id.goToFragmentThreeButton).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, TitBitsFragmentThree())
                .addToBackStack(null)
                .commit()
        }
    }
}