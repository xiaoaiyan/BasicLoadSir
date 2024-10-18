package com.basic.aiyan.basicloadsir.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.basic.aiyan.basicloadsir.databinding.ActivityTitleBinding
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * Description：TODO
 * Create Time：2017/3/20 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
abstract class BaseTitleActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var mBaseLoadService: LoadService<*>
    private lateinit var activityTitleBinding: ActivityTitleBinding
    private lateinit var viewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTitleBinding = ActivityTitleBinding.inflate(layoutInflater)
        addContent()
        setContentView(activityTitleBinding.root)
        initView()
        initNet()
    }

    private fun addContent() {
        activityTitleBinding.tvTitleTitle.text = contentTitle
        activityTitleBinding.llTitleBack.setOnClickListener { backClick() }
        viewBinding = getViewBinding(layoutInflater)
        activityTitleBinding.flContent.addView(viewBinding.root)
        mBaseLoadService = LoadSir.getDefault().register(activityTitleBinding.flContent) { v: View -> this.onNetReload(v) }
    }

    private fun backClick() {
        finish()
    }

    protected abstract fun getViewBinding(layoutInflater: LayoutInflater): VB

    protected abstract val contentTitle: String

    protected abstract fun initView()

    protected abstract fun initNet()

    protected abstract fun onNetReload(v: View?)
}
