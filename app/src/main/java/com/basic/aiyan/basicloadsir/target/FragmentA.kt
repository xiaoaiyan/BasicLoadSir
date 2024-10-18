package com.basic.aiyan.basicloadsir.target

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.base.BaseFragment
import com.basic.aiyan.basicloadsir.callback.ErrorCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.basicloadsir.databinding.FragmentAContentBinding

/**
 * 
 * Create Time:2017/9/5 13:28
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class FragmentA : BaseFragment<FragmentAContentBinding>() {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAContentBinding {
        return FragmentAContentBinding.inflate(inflater, container, false)
    }

    override fun loadNet() {
        // do net here... call back
        postCallbackDelayed(mBaseLoadService, ErrorCallback::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onNetReload(v: View?) {
        viewBinding.tvResultA.text = "Oh, Yes."
        Toast.makeText(context, "reload in Fragment A", Toast.LENGTH_SHORT).show()
        mBaseLoadService.showCallback(LoadingCallback::class.java)
        //do retry logic...
        //callback
        postSuccessDelayed(mBaseLoadService)
    }
}