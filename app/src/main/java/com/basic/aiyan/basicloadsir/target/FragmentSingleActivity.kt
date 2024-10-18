package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.R

/**
 * 
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class FragmentSingleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportFragmentManager.beginTransaction().add(R.id.fl_content, NormalFragment()).commit()
    }

    companion object {
        private const val TAG = "FragmentSingleActivity"
    }
}
