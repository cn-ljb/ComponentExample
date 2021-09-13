package com.ljb.component.user

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ljb.component.comm.router.RouterManager

class UserMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        findViewById<Button>(R.id.btn_user).setOnClickListener {
            RouterManager.startActivity(this, "app/AppMainActivity")
        }
    }
}