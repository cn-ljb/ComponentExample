package com.ljb.component

import android.content.Context
import com.ljb.component.comm.router.RouterManager

object AppInit {

    fun init(context: Context) {
        // 初始化工作
        initRouter()
    }

    private fun initRouter() {
        RouterManager.addRouter("app/AppMainActivity" , AppMainActivity::class.java)
    }

}