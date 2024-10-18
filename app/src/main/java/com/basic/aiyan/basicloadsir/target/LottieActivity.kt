package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.LottieEmptyCallback
import com.basic.aiyan.basicloadsir.callback.LottieLoadingCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class LottieActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val loadSir = LoadSir.Builder()
            .addCallback(LottieLoadingCallback())
            .addCallback(LottieEmptyCallback())
            .setDefaultCallback(LottieLoadingCallback::class.java)
            .build()
        loadService = loadSir.register(this) {
            loadService.showCallback(LottieLoadingCallback::class.java)
            postSuccessDelayed(loadService, 1500)
        }
        postCallbackDelayed(loadService, LottieEmptyCallback::class.java)
    }
}
