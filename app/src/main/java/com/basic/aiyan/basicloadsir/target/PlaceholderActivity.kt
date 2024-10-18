package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.PlaceholderCallback
import com.basic.aiyan.loadsir.callback.Callback.OnReloadListener
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/3 11:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class PlaceholderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placeholder)
        val loadSir = LoadSir.Builder()
            .addCallback(PlaceholderCallback())
            .setDefaultCallback(PlaceholderCallback::class.java)
            .build()
        //do retry logic...
        val loadService = loadSir.register(this, OnReloadListener { _: View -> })
        postSuccessDelayed(loadService, 1000)
    }
}
