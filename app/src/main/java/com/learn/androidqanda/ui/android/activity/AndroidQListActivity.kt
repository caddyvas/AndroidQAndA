package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.LayoutPagerGenericBinding
import com.learn.androidqanda.ui.android.adapter.AndroidFragmentPagerAdapter
import com.learn.androidqanda.ui.android.fragment.qandafragments.AndroidQAndAListFragmentOne
import com.learn.androidqanda.ui.android.fragment.qandafragments.AndroidQAndAListFragmentThree
import com.learn.androidqanda.ui.android.fragment.qandafragments.AndroidQAndAListFragmentTwo

class AndroidQListActivity : AppCompatActivity(){

    private lateinit var layoutPagerQAndABinding: LayoutPagerGenericBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutPagerQAndABinding = LayoutPagerGenericBinding.inflate(layoutInflater)
        setContentView(layoutPagerQAndABinding.root)

        supportActionBar?.title = "Android Essentials"

        // find the view pager that will allow the user to swipe between fragments
        val viewPager: ViewPager2 = findViewById(R.id.androidViewPager)

        // add fragments in viewpager adapter
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(AndroidQAndAListFragmentOne())
        fragmentList.add(AndroidQAndAListFragmentTwo())
        fragmentList.add(AndroidQAndAListFragmentThree())

        // create an adapter to show the corresponding fragment
        val adapter = AndroidFragmentPagerAdapter(this, fragmentList)

        // set the adapter
        viewPager.adapter = adapter
    }
}