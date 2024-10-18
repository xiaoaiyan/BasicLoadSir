package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.EmptyCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * Description:
 * Create Time:2017/9/26 14:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class KeepTitleFragment : Fragment() {
    private lateinit var loadService: LoadService<*>
    private lateinit var rootView: ViewGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contentView = rootView.findViewById<LinearLayout>(R.id.ll_content)
        val loadSir = LoadSir.Builder()
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .build()
        loadService = loadSir.register(contentView) { loadService.showSuccess() }
        postCallbackDelayed(loadService, EmptyCallback::class.java, 1200)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.title_title_bar, container, false) as ViewGroup
        return rootView
    }

    override fun onDetach() {
        super.onDetach()
    }
}
