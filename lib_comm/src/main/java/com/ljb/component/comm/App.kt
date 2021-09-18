package com.ljb.component.comm

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        initRouter()
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()   // 打印日志
            ARouter.openDebug() // 开启调试模式
        }
        ARouter.init(this) // 初始化
    }
}