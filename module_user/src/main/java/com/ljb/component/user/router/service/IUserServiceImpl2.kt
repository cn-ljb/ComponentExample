package com.ljb.component.user.router.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.ljb.component.comm.router.service.IUserService2
import com.ljb.component.user.utils.UserUtils

@Route(path = "/user/UserService")
class IUserServiceImpl2 : IUserService2 {

    override fun init(context: Context?) {

    }

    override fun isLogin(): Boolean {
        return UserUtils.isLogin()
    }

}