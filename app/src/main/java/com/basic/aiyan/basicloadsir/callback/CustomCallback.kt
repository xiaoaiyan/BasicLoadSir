package com.basic.aiyan.basicloadsir.callback

import android.content.Context
import android.view.View
import android.widget.Toast
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.loadsir.callback.Callback

/**
 * 
 * Create Time:2017/9/3 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class CustomCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_custom
    }

    override fun onReloadEvent(context: Context, view: View): Boolean {
        Toast.makeText(context.applicationContext, "Hello buddy, how r u! :p", Toast.LENGTH_SHORT)
            .show()
        view.findViewById<View>(R.id.iv_gift).setOnClickListener {
            Toast.makeText(
                context.applicationContext,
                "It's your gift! :p",
                Toast.LENGTH_SHORT
            ).show()
        }
        return true
    }
}
