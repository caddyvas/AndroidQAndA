package com.learn.androidqanda.ui.android.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.ListviewAndroidQAndALayoutBinding
import com.learn.androidqanda.utilities.DialogBoxCustomHelper

/**
 * A simple [Fragment] subclass.
 * Use the [AndroidQAndAListFragmentOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class AndroidQAndAListFragmentOne : Fragment() {

    private lateinit var listViewAndroidQAndA: ListviewAndroidQAndALayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        listViewAndroidQAndA = ListviewAndroidQAndALayoutBinding.inflate(layoutInflater)
        return listViewAndroidQAndA.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val androidQuestionArray = resources.getStringArray(R.array.android_questions_1)
        val androidAnswersArrays = resources.getStringArray(R.array.android_answers_1)

        // access the listView from xml file
        val mListView = view.findViewById<ListView>(R.id.androidQAndAListView)
        arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
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
                position
            )
        }
    }
}