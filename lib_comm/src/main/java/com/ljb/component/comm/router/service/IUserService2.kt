package com.ljb.component.comm.router.service

import com.alibaba.android.arouter.facade.template.IProvider

interface IUserService2 : IProvider {

    /**
     * 是否登录
     */
    fun isLogin(): Boolean
}