package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.basicloadsir.callback.TimeoutCallback
import com.basic.aiyan.loadsir.callback.Callback.OnReloadListener
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/3 11:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class ViewTargetActivity : AppCompatActivity() {

    private lateinit var loadService: LoadService<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val imageView = findViewById<ImageView>(R.id.iv_img)
        val loadSir = LoadSir.Builder()
            .addCallback(TimeoutCallback())
            .addCallback(LoadingCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .build()
        loadService = loadSir.register(imageView, OnReloadListener { v: View? ->
            loadService.showCallback(LoadingCallback::class.java)
            //do retry logic...
            //callback
            postSuccessDelayed(loadService)
        })
        postCallbackDelayed(loadService, TimeoutCallback::class.java)
    }
}
