package com.basic.aiyan.basicloadsir.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/6 14:34
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var mBaseLoadService: LoadService<*>

    protected lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = getViewBinding(inflater, container)
        mBaseLoadService = LoadSir.getDefault().register(viewBinding.root) { v -> onNetReload(v) }
        return mBaseLoadService.loadLayout
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadNet()
    }

    protected abstract fun loadNet()

    protected abstract fun onNetReload(v: View?)
}
