package com.basic.aiyan.basicloadsir

import android.app.Application
import com.basic.aiyan.basicloadsir.callback.CustomCallback
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.ErrorCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.basicloadsir.callback.TimeoutCallback
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/3 14:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeoutCallback())
            .addCallback(CustomCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
    }
}
