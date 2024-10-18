package com.basic.aiyan.basicloadsir.callback

import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.loadsir.callback.Callback

/**
 * 
 * Create Time:2017/9/4 10:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class ErrorCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}
