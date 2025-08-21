package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.LayoutPagerGenericBinding

class AndroidEssentialsActivity: AppCompatActivity() {

    private lateinit var layoutEssentialActivity: LayoutPagerGenericBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // resuse the same layout. rename the layout to generic later
        layoutEssentialActivity = LayoutPagerGenericBinding.inflate(layoutInflater)
        setContentView(layoutEssentialActivity.root)

        supportActionBar?.title = "Android Essentials"

        // find the view pager that will allow the user to swipe between fragments
        val viewPager: ViewPager2 = findViewById(R.id.androidViewPager)

        // add fragments in viewpager adapter
        val fragmentList = ArrayList<Fragment>()

    }
}