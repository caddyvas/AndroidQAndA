package com.learn.androidqanda.ui.android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.learn.androidqanda.R
import com.learn.androidqanda.databinding.LayoutPagerGenericBinding
import com.learn.androidqanda.ui.android.adapter.AndroidFragmentPagerAdapter
import com.learn.androidqanda.ui.android.fragment.essentialcompfragments.EssentialScreenOrientationFragment
import com.learn.androidqanda.ui.android.fragment.essentialcompfragments.JetpackComponentsFragment
import com.learn.androidqanda.ui.android.fragment.essentialcompfragments.jetpackcompsDemo.EssentialsDemoFragment

/**
 * onSaveInstanceState(Bundle outState)
 * Called before your Activity/Fragment is destroyed (e.g. rotation, process death).
 * You put values into the Bundle.
 * Exists in both Activity and Fragment.
 *
 * onRestoreInstanceState(Bundle savedInstanceState)
 * Only available in Activity, not in Fragment.
 * Called after onStart() when the system passes back the saved state.
 * Useful if you want to restore UI state after the layout is fully created.
 */


class AndroidEssentialsActivity : AppCompatActivity() {

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
        fragmentList.add(EssentialScreenOrientationFragment())
        fragmentList.add(JetpackComponentsFragment())
        fragmentList.add(EssentialsDemoFragment())

        // create an adapter to show the corresponding fragment
        val fragmentsAdapter = AndroidFragmentPagerAdapter(this, fragmentList)

        viewPager.adapter = fragmentsAdapter
    }
}