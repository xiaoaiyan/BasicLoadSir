package com.basic.aiyan.basicloadsir

import android.os.Handler
import android.os.Looper
import com.basic.aiyan.loadsir.callback.Callback
import com.basic.aiyan.loadsir.core.LoadService

/**
 * 
 * Create Time:2017/9/4 15:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
object PostUtil {
    private const val DELAY_TIME = 1000

    @JvmStatic
    @JvmOverloads
    fun postCallbackDelayed(
        loadService: LoadService<*>,
        clazz: Class<out Callback?>,
        delay: Long = DELAY_TIME.toLong()
    ) {
        Handler(Looper.getMainLooper()).postDelayed({ loadService.showCallback(clazz) }, delay)
    }

    @JvmStatic
    @JvmOverloads
    fun postSuccessDelayed(loadService: LoadService<*>, delay: Long = DELAY_TIME.toLong()) {
        Handler(Looper.getMainLooper()).postDelayed({ loadService.showSuccess() }, delay)
    }
}
