package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.LayoutPagerAndroidQAndABinding
import com.learn.androidqanda.ui.android.adapter.AndroidFragmentPagerAdapter
import com.learn.androidqanda.ui.android.fragment.AndroidQAndAListFragmentOne
import com.learn.androidqanda.ui.android.fragment.AndroidQAndAListFragmentTwo

class AndroidQListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var layoutPagerQAndABinding: LayoutPagerAndroidQAndABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutPagerQAndABinding = LayoutPagerAndroidQAndABinding.inflate(layoutInflater)
        setContentView(layoutPagerQAndABinding.root)

        // find the view pager that will allow the user to swipe between fragments
        val viewPager: ViewPager2 = findViewById(R.id.androidQAndAPager)

        // add fragments in viewpager adapter
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(AndroidQAndAListFragmentOne())
        fragmentList.add(AndroidQAndAListFragmentTwo())

        // create an adapter to show the corresponding fragment
        val adapter = AndroidFragmentPagerAdapter(this, fragmentList)

        // set the adapter
        viewPager.adapter = adapter
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}