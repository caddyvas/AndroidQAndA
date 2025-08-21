package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.LayoutPagerGenericBinding
import com.learn.androidqanda.ui.android.adapter.AndroidFragmentPagerAdapter
import com.learn.androidqanda.ui.android.fragment.architecturefragments.MVCFragment
import com.learn.androidqanda.ui.android.fragment.architecturefragments.MVPFragment
import com.learn.androidqanda.ui.android.fragment.architecturefragments.MVVMFragment

class AndroidArchitectureActivity: AppCompatActivity() {

    private lateinit var layoutArchitectureBinding: LayoutPagerGenericBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutArchitectureBinding = LayoutPagerGenericBinding.inflate(layoutInflater)
        setContentView(layoutArchitectureBinding.root)

        supportActionBar?.title ="Architecture Patterns"

        // the view pager that will allow the user to swipe between fragments
        val viewPager: ViewPager2 = findViewById(R.id.androidViewPager)

        // create a fragment list to add them in the adapter
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(MVCFragment())
        fragmentList.add(MVPFragment())
        fragmentList.add(MVVMFragment())

        // create an adapter to show the corresponding fragment
        val fragmentsAdapter = AndroidFragmentPagerAdapter(this, fragmentList)

        // add the fragment adapter to viewpager adapter
        viewPager.adapter = fragmentsAdapter

    }
}