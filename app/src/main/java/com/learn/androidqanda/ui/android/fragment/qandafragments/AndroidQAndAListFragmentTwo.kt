package com.learn.androidqanda.ui.android.fragment.qandafragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.ListviewAndroidQAndALayoutBinding
import com.learn.androidqanda.utilities.DialogBoxCustomHelper

/**
 * A simple [Fragment] subclass.
 * Use the [AndroidQAndAListFragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */

class AndroidQAndAListFragmentTwo : Fragment() {

    private lateinit var listViewAndroidQAndA: ListviewAndroidQAndALayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        listViewAndroidQAndA = ListviewAndroidQAndALayoutBinding.inflate(layoutInflater)
        return listViewAndroidQAndA.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val androidQuestionArray = resources.getStringArray(R.array.android_questions_2)
        val androidAnswersArrays = resources.getStringArray(R.array.android_answers_2)

        // access the listView from xml file
        val mListView = view.findViewById<ListView>(R.id.androidQAndAListView)
        val mTextView = view.findViewById<TextView>(R.id.androidQAndAListViewTxtView)
        mTextView.text = resources.getString(R.string.swipe_left)
        arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.array_adapter_textview,
            androidQuestionArray
        )
        mListView.adapter = arrayAdapter

        mListView.setOnItemClickListener { _, _, position, _ ->
            val element = arrayAdapter.getItem(position)
            println("element: ${element.toString()} is clicked ")
            DialogBoxCustomHelper().showCustomAndroidQAndADialog(
                requireContext(),
                androidQuestionArray,
                androidAnswersArrays,
                false,
                position
            )
        }
    }
}