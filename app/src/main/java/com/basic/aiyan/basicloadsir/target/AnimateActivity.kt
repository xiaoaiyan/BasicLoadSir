package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.AnimateCallback
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class AnimateActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        // Your can change the callback on sub thread directly.
        val loadSir = LoadSir.Builder()
            .addCallback(EmptyCallback())
            .addCallback(AnimateCallback())
            .setDefaultCallback(AnimateCallback::class.java)
            .build()
        loadService = loadSir.register(this) {
            // Your can change the status out of Main thread.
            Thread {
                loadService.showCallback(AnimateCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback on sub thread
                loadService.showSuccess()
            }.start()
        }
        postCallbackDelayed(loadService, EmptyCallback::class.java, 1000)
    }
}
