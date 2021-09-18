package com.ljb.component.user

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.ljb.component.comm.router.RouterManager

@Route(path = "/user/UserMainActivity" , group = "user")
class UserMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        findViewById<Button>(R.id.btn_user).setOnClickListener {
//            RouterManager.startActivity(this, "app/AppMainActivity")

            ARouter.getInstance().build("/app/AppMainActivity").navigation()
        }
    }

}