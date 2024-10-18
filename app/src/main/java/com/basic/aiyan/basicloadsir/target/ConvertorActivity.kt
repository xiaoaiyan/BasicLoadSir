package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.ErrorCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.loadsir.callback.Callback
import com.basic.aiyan.loadsir.callback.SuccessCallback
import com.basic.aiyan.loadsir.core.Convertor
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir
import java.util.Random

/**
 * 
 * Create Time:2017/9/4 10:35
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class ConvertorActivity : AppCompatActivity() {

    private lateinit var loadService: LoadService<*>

    private val mHttpResult = HttpResult(Random().nextInt(2), ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity_convertor)
        val loadSir = LoadSir.Builder()
            .addCallback(LoadingCallback())
            .addCallback(EmptyCallback())
            .addCallback(ErrorCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .build()
        loadService = loadSir.register<HttpResult>(this, {
            loadService.showCallback(LoadingCallback::class.java)
            postCallbackDelayed(loadService, SuccessCallback::class.java)
        },
            { httpResult ->
                var resultCode: Class<out Callback?> = SuccessCallback::class.java
                resultCode = when (httpResult.resultCode) {
                    SUCCESS_CODE -> if (httpResult.data.isEmpty()) {
                        EmptyCallback::class.java
                    } else {
                        SuccessCallback::class.java
                    }

                    ERROR_CODE -> ErrorCallback::class.java
                    else -> ErrorCallback::class.java
                }
                resultCode
            })
        Handler(Looper.getMainLooper()).postDelayed({ // do net here...
            //callback
            loadService.showWithConvertor(mHttpResult)
        }, 500)
    }

    private inner class HttpResult(val resultCode: Int, val data: List<Any>)

    companion object {
        private const val SUCCESS_CODE = 0x00
        private const val ERROR_CODE = 0x01
    }
}
