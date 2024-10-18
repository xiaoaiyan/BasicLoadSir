package com.basic.aiyan.basicloadsir.target

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.PostUtil.postSuccessDelayed
import com.basic.aiyan.basicloadsir.base.BaseFragment
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.basicloadsir.databinding.FragmentBContentBinding

/**
 * 
 * Create Time:2017/9/5 13:27
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class FragmentB : BaseFragment<FragmentBContentBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBContentBinding {
        return FragmentBContentBinding.inflate(inflater, container, false)
    }

    override fun loadNet() {
        // do net here...
        // call back
        postCallbackDelayed(mBaseLoadService, EmptyCallback::class.java)
    }

    override fun onNetReload(v: View?) {
        viewBinding.tvResultB.text = "Oh, Yes too."
        Toast.makeText(context, "reload in Fragment B", Toast.LENGTH_SHORT).show()
        mBaseLoadService.showCallback(LoadingCallback::class.java)

        //do retry logic...
        //callback
        postSuccessDelayed(mBaseLoadService)
    }
}