package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.ActivityTitbitsBinding
import com.learn.androidqanda.ui.android.fragment.titbitsfragments.DualFragmentHostFragment
import com.learn.androidqanda.ui.android.fragment.titbitsfragments.OnFragmentThreeDataPass
import com.learn.androidqanda.ui.android.fragment.titbitsfragments.SharedViewModel

/*
Lifecycle-safe via LiveData.

No need for tight coupling between Fragments and Activity.

Clean architecture with ViewModel promoting testability and separation of concerns.
 */

class AndroidTitBitsActivity : AppCompatActivity(), OnFragmentThreeDataPass {
    private lateinit var activityTitbits: ActivityTitbitsBinding

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityTitbits = ActivityTitbitsBinding.inflate(layoutInflater)
        setContentView(activityTitbits.root)

        supportActionBar?.title = "Activity Fragments Data Handling"

        textView = findViewById<TextView>(R.id.titbits_activityTextView)

        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        supportFragmentManager.beginTransaction().replace(
            R.id.main_fragment_container,
            DualFragmentHostFragment()
        ).commit()
    }

    override fun onDataFromFragment3(data: String) {
        // receive the data from Fragment 3
        textView.text = data
    }
}