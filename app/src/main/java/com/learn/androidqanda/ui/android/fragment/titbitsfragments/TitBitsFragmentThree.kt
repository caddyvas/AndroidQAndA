package com.learn.androidqanda.ui.android.fragment.titbitsfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R
import java.lang.ClassCastException

class TitBitsFragmentThree : Fragment() {

    // Interface listener for sending data to the activity
    private var dataPassListener: OnFragmentThreeDataPass? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // initialize the listener by casting the activity to the interface
        if (context is OnFragmentThreeDataPass) {
            dataPassListener = context
        } else {
            throw ClassCastException("$context must implement OnFragment3DataPass")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment3_titbits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // For example, on button click
        view.findViewById<Button>(R.id.sendDataButton).setOnClickListener {
            dataPassListener?.onDataFromFragment3("Message from Fragment 3")
            requireActivity().supportFragmentManager.popBackStack()
        }

        // This is direct communication from Fragment3 to Fragment4 via arguments (which is safe and standard).
        //  on button click, go to fragment 4
        view.findViewById<Button>(R.id.sendDataToFragmentButton).setOnClickListener {
            // send data to fragment 4 using bundle
            val fragment4 = TitBitsFragmentFour()
            val bundle = Bundle()
            bundle.putString(
                "data_key",
                "Message carried from Fragment 3 through bundle and arguments"
            )
            fragment4.arguments = bundle

            // replace fragment3 with fragment4
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment4) // or your container ID
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDetach() {
        super.onDetach()
        dataPassListener = null // Clean up reference to avoid memory leaks
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (view as? ViewGroup)?.removeAllViews()  // Just in case view references linger
    }
}