package com.basic.aiyan.basicloadsir.target

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basic.aiyan.basicloadsir.PostUtil.postCallbackDelayed
import com.basic.aiyan.basicloadsir.R
import com.basic.aiyan.basicloadsir.callback.CustomCallback
import com.basic.aiyan.basicloadsir.callback.ErrorCallback
import com.basic.aiyan.basicloadsir.callback.LoadingCallback
import com.basic.aiyan.loadsir.core.LoadService
import com.basic.aiyan.loadsir.core.LoadSir

/**
 * 
 * Create Time:2017/9/5 13:28
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class NormalFragment : Fragment() {

    private lateinit var loadService: LoadService<*>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loadSir = LoadSir.Builder()
            .addCallback(CustomCallback())
            .addCallback(LoadingCallback())
            .addCallback(ErrorCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .build()
        val rootView = inflater.inflate(R.layout.fragment_a_content, container, false)
        loadService = loadSir.register(rootView) {
            // Your can change the status out of Main thread.
            Thread {
                loadService.showCallback(LoadingCallback::class.java)
                //do retry logic...
                SystemClock.sleep(500)
                //callback
                loadService.showCallback(CustomCallback::class.java)
            }.start()
        }
        return loadService.loadLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postCallbackDelayed(loadService, ErrorCallback::class.java)
    }
}