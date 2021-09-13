package com.ljb.component.comm.router.service

/**
 * User模块对外提供的功能接口
 * */
interface IUserService : IService {

    /**
     * 是否登录
     */
    fun isLogin(): Boolean
}