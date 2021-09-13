package com.ljb.component.user.startup

import android.content.Context
import androidx.startup.Initializer
import com.ljb.component.user.UserInit

class UserInitializer : Initializer<UserInit> {

    override fun create(context: Context): UserInit {
        UserInit.init(context)
        return UserInit
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}