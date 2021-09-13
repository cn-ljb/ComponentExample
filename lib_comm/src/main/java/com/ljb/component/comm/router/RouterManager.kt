package com.ljb.component.comm.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ljb.component.comm.router.service.IService
import com.ljb.component.comm.router.service.IUserService

/**
 * 路由管理类
 * 提供路由注册、查询等功能
 * */
object RouterManager {

    const val TAG = "RouterManager"

    // 存储路由的的容器
    private val mRouterMap = HashMap<String, Class<*>>()

    /**
     * 添加路由
     * @param path 路由路径
     * @param clazz 路由目标
     * */
    fun addRouter(path: String, clazz: Class<*>) {
        mRouterMap[path] = clazz
    }

    /**
     * 开启Activity
     * */
    fun startActivity(context: Context, path: String, bundle: Bundle? = null) {
        val clazz = mRouterMap[path]
        if (clazz == null) {
            val log = "not found router by path !"
            Log.e(TAG, log)
            showToast(context, log)
            return
        }
        // 判断是否是Activity的子类
        if (Activity::class.java.isAssignableFrom(clazz)) {
            val intent = Intent(context, clazz)
            // 添加参数
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            context.startActivity(intent)
        } else {
            val log = "router's not Activity !"
            Log.e(TAG, log)
            showToast(context, log)
        }
    }

    /**
     * 获取Fragment
     * */
    fun getFragment(context: Context, path: String, bundle: Bundle? = null): Fragment? {
        val clazz = mRouterMap[path]
        if (clazz == null) {
            val log = "not found router by path !"
            Log.e(TAG, log)
            showToast(context, log)
            return null
        }
        // 判断是否是Fragment的子类
        if (Fragment::class.java.isAssignableFrom(clazz)) {
            val fragment = clazz.newInstance() as Fragment
            //添加参数
            if (bundle != null) {
                fragment.arguments = bundle
            }
            return fragment
        } else {
            val log = "router's not Fragment !"
            Log.e(TAG, log)
            showToast(context, log)
        }
        return null
    }


    /**
     * 获取用户模块提供的服务
     * */
    fun getUserService(context: Context): IUserService? {
        val clazz = mRouterMap["user/UserService"]
        if (clazz == null) {
            val log = "not found service router by path !"
            Log.e(TAG, log)
            showToast(context, log)
            return null
        }
        // 判断是否是Service & IUserService
        if (IService::class.java.isAssignableFrom(clazz)
            && IUserService::class.java.isAssignableFrom(clazz)
        ) {
            return clazz.newInstance() as IUserService
        } else {
            val log = "router's not IUserService !"
            Log.e(TAG, log)
            showToast(context, log)
        }
        return null
    }

    private fun showToast(context: Context, log: String) {
        Toast.makeText(context, log, Toast.LENGTH_SHORT).show()
    }

}