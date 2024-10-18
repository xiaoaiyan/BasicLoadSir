package com.basic.aiyan.basicloadsir.target

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.R

/**
 * 
 * Create Time:2017/9/29 13:54
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class BestPracticesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_practices)
    }

    fun mvpActivity(view: View?) {}

    fun onLottie(view: View?) {
        startActivity(Intent(this, LottieActivity::class.java))
    }
}
