package com.basic.aiyan.basicloadsir.target

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.base.BaseTitleActivity
import com.basic.aiyan.basicloadsir.callback.ErrorCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.basicloadsir.databinding.ActivityContentBinding

/**
 * Description:
 * Create Time:2017/9/4 10:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class KeepTitleActivity : BaseTitleActivity<ActivityContentBinding>() {
    override val contentTitle: String
        get() = "Title"

    @SuppressLint("SetTextI18n")
    override fun initView() {
        val mTvMsg = findViewById<TextView>(R.id.tv_subTitle)
        mTvMsg.text = "Keep Title In Activity"
    }

    override fun initNet() {
        postCallbackDelayed(mBaseLoadService, ErrorCallback::class.java)
    }

    override fun onNetReload(v: View?) {
        mBaseLoadService.showCallback(LoadingCallback::class.java)
        postSuccessDelayed(mBaseLoadService)
    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityContentBinding {
        return ActivityContentBinding.inflate(layoutInflater)
    }
}
