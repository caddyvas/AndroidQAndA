package com.learn.androidqanda.ui.android.fragment.essentialcompfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learn.androidqanda.R

/**
 * This fragment uses recyclerview which is efficiently render dynamic, growing lists - even with
 * thousands of TextViews, performance stay solid
 */

class JetpackComponentsFragment : Fragment(R.layout.fragment_essentials_jetpack_comps) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EssentialJetpackAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.textRecyclerView)
        adapter = EssentialJetpackAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Static list of texts to display
        val staticTextItems = listOf(
            resources.getText(R.string.essentials_jc_generic),
            resources.getText(R.string.essentials_jc_remember),
            resources.getText(R.string.essentials_jc_remember_saveable),
            resources.getText(R.string.essentials_livedata),
            resources.getText(R.string.essentials_stateflow),
            resources.getText(R.string.essentials_sharedflow)
        )
        adapter.addTextContent(staticTextItems)
    }
}