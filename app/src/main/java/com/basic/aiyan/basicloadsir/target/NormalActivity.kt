package com.basic.aiyan.basicloadsir.target

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir
import kotlin.concurrent.thread

/**
 * 
 * Create Time:2017/9/4 10:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class NormalActivity : AppCompatActivity() {

    private lateinit var loadService: LoadService<*>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        // Your can change the callback on sub thread directly.
        loadService = LoadSir.getDefault().register(this) {
            thread {
                // Your can change the status out of Main thread.
                loadService.showCallback(LoadingCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback
                loadService.showSuccess()
            }
        }.setCallBack(EmptyCallback::class.java) { _, view ->
            val mTvEmpty = view.findViewById<TextView>(R.id.tv_empty)
            mTvEmpty.text = "fine, no data. You must fill it!"
        }
        PostUtil.postCallbackDelayed(loadService, EmptyCallback::class.java)
    }
}
