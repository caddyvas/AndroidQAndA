package com.learn.androidqanda.ui.android.adapter

/**
 * This adapter acts as a bridge between a view and the underlying data that helps to fil the view.
 * Take data from a source such as an array or database, convert each item into a result view that is
 * displayed within anthe activity
 */
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.learn.androidqanda.ui.android.fragment.AndroidQAndAListFragmentOne

class AndroidFragmentPagerAdapter(fa: FragmentActivity, var fragmentList: ArrayList<Fragment>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                fragmentList[0]
            }
            1 -> {
                fragmentList[1]
            }
            else -> {
                AndroidQAndAListFragmentOne()
            }
        }
    }
}