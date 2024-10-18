package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.R

/**
 * 
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MultiFragmentActivity : AppCompatActivity() {
    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_mutil)
        fragmentA = FragmentA()
        fragmentB = FragmentB()
        supportFragmentManager.beginTransaction().add(R.id.fl_content, fragmentA).commit()
        supportFragmentManager.beginTransaction().add(R.id.fl_content, fragmentB).commit()
        supportFragmentManager.beginTransaction().show(fragmentA).hide(fragmentB).commit()
    }


    fun showFragmentA(view: View?) {
        supportFragmentManager.beginTransaction().show(fragmentA).hide(fragmentB).commit()
    }

    fun showFragmentB(view: View?) {
        supportFragmentManager.beginTransaction().show(fragmentB).hide(fragmentA).commit()
    }

    companion object {
        private const val TAG = "FragmentSingleActivity"
    }
}
