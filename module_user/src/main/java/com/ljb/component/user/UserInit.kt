package com.ljb.component.user

import android.content.Context
import com.ljb.component.comm.router.RouterManager
import com.ljb.component.user.router.service.UserServiceImpl

object UserInit {

    fun init(context: Context) {
        initRouter()
    }

    private fun initRouter() {
        RouterManager.addRouter("user/UserMainActivity", UserMainActivity::class.java)
        RouterManager.addRouter("user/UserFragment", UserFragment::class.java)
        RouterManager.addRouter("user/UserService", UserServiceImpl::class.java)
    }

}