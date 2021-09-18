package com.ljb.component

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.ljb.component.comm.router.service.IUserService2

//import com.ljb.component.user.UserMainActivity
@Route(path = "/app/AppMainActivity")
class AppMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_user).setOnClickListener {

//            val intent = Intent(this, UserMainActivity::class.java)
//            startActivity(intent)

//            RouterManager.startActivity(this, "user/UserMainActivity")


            ARouter.getInstance().build("/user/UserMainActivity").navigation()
        }

        findViewById<Button>(R.id.btn_user_fragment).setOnClickListener {

            ARouter.getInstance().build("/user/UserFragment").navigation()?.apply {
                if (this is Fragment) {
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.replace(R.id.fl_fragment, this)
                    beginTransaction.commit()
                }
            }

        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {

            ARouter.getInstance().build("user/UserService").navigation()?.apply {
                if (this is IUserService2) {
                    Toast.makeText(
                        this@AppMainActivity,
                        "登录状态：${this.isLogin()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}