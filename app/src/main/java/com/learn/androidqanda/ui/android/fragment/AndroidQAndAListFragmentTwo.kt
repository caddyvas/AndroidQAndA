package com.learn.androidqanda.ui.android.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R

/**
 * A simple [Fragment] subclass.
 * Use the [AndroidQAndAListFragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */

class AndroidQAndAListFragmentTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_android_q_and_a_list_one, container, false)
    }
}