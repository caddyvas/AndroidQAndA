package com.learn.androidqanda.ui.android.fragment.titbitsfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.learn.androidqanda.R

// combines Fragment 1 and Fragment 2
class DualFragmentHostFragment: Fragment(R.layout.fragment_dual_host) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_1, TitBitsFragmentOne())
            .replace(R.id.fragment_container_2, TitBitsFragmentTwo())
            .commit()
    }
}