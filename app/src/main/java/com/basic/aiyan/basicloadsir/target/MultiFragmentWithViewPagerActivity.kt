package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.basic.aiyan.basicloadsir.R
import com.google.android.material.tabs.TabLayout

/**
 * 
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MultiFragmentWithViewPagerActivity : AppCompatActivity() {
    private val fragments: MutableList<Fragment> = ArrayList()
    private val tabTitles = arrayOf("Fragment A", "Fragment B")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_viewpager)
        val viewpager = findViewById<ViewPager>(R.id.viewpager)
        val tablelayout = findViewById<TabLayout>(R.id.tablayout)

        fragments.add(FragmentA())
        fragments.add(FragmentB())
        viewpager.adapter =
            PagerAdapter(
                supportFragmentManager
            )

        tablelayout.setupWithViewPager(viewpager)
        tablelayout.tabMode = TabLayout.MODE_FIXED
    }

    private inner class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(
        fm!!
    ) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}
