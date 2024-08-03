package com.learn.androidqanda.ui.android.fragment

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

/** This fragment consists of types of layouts
 * Linear Layout
 * Relative Layout
 * Frame Layout
 * Constraint Layout
 * Table Layout
 * Absolute Layout
 * List View
 * Grid View
 */

class AndroidQAndAListFragmentThree : Fragment() {

    private lateinit var layoutAndroidQAndA: ListviewAndroidQAndALayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layoutAndroidQAndA = ListviewAndroidQAndALayoutBinding.inflate(layoutInflater)
        return layoutAndroidQAndA.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // use array adapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val androidQuestionArray = resources.getStringArray(R.array.android_questions_3)
        val androidAnswersArrays = resources.getStringArray(R.array.android_answers_3)

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
            DialogBoxCustomHelper().showCustomAndroidQAndADialogForLayouts(
                requireContext(),
                androidQuestionArray,
                androidAnswersArrays,
                position
            )
        }
    }

}