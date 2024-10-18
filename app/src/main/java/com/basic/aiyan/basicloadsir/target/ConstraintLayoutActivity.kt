package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.os.SystemClock
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var loadService: LoadService<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraintlayout)
        initLoadSir()
    }

    private fun initLoadSir() {
        val tvCenter = findViewById<TextView>(R.id.tv_center)
        loadService = LoadSir.getDefault().register(tvCenter) {
            // Your can change the status out of Main thread.
            Thread {
                loadService.showCallback(LoadingCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback
                loadService.showSuccess()
            }.start()
        }
        postCallbackDelayed(loadService, EmptyCallback::class.java, 1000)
    }
}
