package com.ljb.component.startup

import android.content.Context
import androidx.startup.Initializer
import com.ljb.component.AppInit

class AppInitializer : Initializer<AppInit> {

    override fun create(context: Context): AppInit {
        AppInit.init(context)
        return AppInit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}