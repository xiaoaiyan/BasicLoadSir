package com.basic.aiyan.basicloadsir

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.basic.aiyan.basicloadsir.target.AnimateActivity
import com.basic.aiyan.basicloadsir.target.BestPracticesActivity
import com.basic.aiyan.basicloadsir.target.ConstraintLayoutActivity
import com.basic.aiyan.basicloadsir.target.ConvertorActivity
import com.basic.aiyan.basicloadsir.target.DefaultCallbackActivity
import com.basic.aiyan.basicloadsir.target.FragmentSingleActivity
import com.basic.aiyan.basicloadsir.target.KeepTitleActivity
import com.basic.aiyan.basicloadsir.target.KeepTitleFragmentActivity
import com.basic.aiyan.basicloadsir.target.MultiFragmentActivity
import com.basic.aiyan.basicloadsir.target.MultiFragmentWithViewPagerActivity
import com.basic.aiyan.basicloadsir.target.NormalActivity
import com.basic.aiyan.basicloadsir.target.PlaceholderActivity
import com.basic.aiyan.basicloadsir.target.ViewTargetActivity

/**
 * 
 * Create Time:2017/9/2 16:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById<ScrollView>(R.id.scrollView)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun inActivity(view: View?) {
        startActivity(Intent(this, NormalActivity::class.java))
    }

    fun showPlaceholder(view: View?) {
        startActivity(Intent(this, PlaceholderActivity::class.java))
    }

    fun inActivityWithConvertor(view: View?) {
        startActivity(Intent(this, ConvertorActivity::class.java))
    }

    fun inFragment(view: View?) {
        startActivity(Intent(this, FragmentSingleActivity::class.java))
    }

    fun inFragmentMulti(view: View?) {
        startActivity(Intent(this, MultiFragmentActivity::class.java))
    }

    fun inFragmentViewSirPager(view: View?) {
        startActivity(Intent(this, MultiFragmentWithViewPagerActivity::class.java))
    }

    fun inView(view: View?) {
        startActivity(Intent(this, ViewTargetActivity::class.java))
    }

    fun defaultCallback(view: View?) {
        startActivity(Intent(this, DefaultCallbackActivity::class.java))
    }

    fun animateCallback(view: View?) {
        startActivity(Intent(this, AnimateActivity::class.java))
    }

    fun keepTitleInFragment(view: View?) {
        startActivity(Intent(this, KeepTitleFragmentActivity::class.java))
    }

    fun bestPractices(view: View?) {
        startActivity(Intent(this, BestPracticesActivity::class.java))
    }

    fun keepTitleInActivity(view: View?) {
        startActivity(Intent(this, KeepTitleActivity::class.java))
    }

    fun inConstraintLayoutActivity(view: View?) {
        startActivity(Intent(this, ConstraintLayoutActivity::class.java))
    }
}
