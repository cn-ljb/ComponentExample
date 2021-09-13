package com.ljb.component.user.router.service

import com.ljb.component.comm.router.service.IUserService
import com.ljb.component.user.utils.UserUtils

/**
 * user模块实现对外暴露的功能
 * */
class UserServiceImpl : IUserService {

    override fun isLogin(): Boolean {
        return UserUtils.isLogin()
    }
}