package com.basic.aiyan.basicloadsir.callback

import android.content.Context
import android.view.View
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.loadsir.callback.Callback

/**
 * 
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class PlaceholderCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_placeholder
    }

    override fun onReloadEvent(context: Context, view: View): Boolean {
        return true
    }
}
