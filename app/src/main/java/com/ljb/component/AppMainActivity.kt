package com.ljb.component

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ljb.component.comm.router.RouterManager

//import com.ljb.component.user.UserMainActivity

class AppMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_user).setOnClickListener {
//            val intent = Intent(this, UserMainActivity::class.java)
//            startActivity(intent)
            RouterManager.startActivity(this, "user/UserMainActivity")
        }

        findViewById<Button>(R.id.btn_user_fragment).setOnClickListener {

            RouterManager.getFragment(this, "user/UserFragment")?.apply {
                val beginTransaction = supportFragmentManager.beginTransaction()
                beginTransaction.replace(R.id.fl_fragment, this)
                beginTransaction.commit()
            }

        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {

            RouterManager.getUserService(this)?.apply {
                Toast.makeText(
                    this@AppMainActivity,
                    "登录状态：${this.isLogin()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}