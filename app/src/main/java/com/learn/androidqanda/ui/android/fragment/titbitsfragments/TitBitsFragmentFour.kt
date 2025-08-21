package com.learn.androidqanda.ui.android.fragment.titbitsfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R

class TitBitsFragmentFour: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment4_titbits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // get message from previous fragment
        val message = arguments?.getString("data_key")
        view.findViewById<TextView>(R.id.fragment4_receivedText).text = message
    }
}