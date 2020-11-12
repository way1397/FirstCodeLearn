package com.wsf.firstcodelearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.service.ServiceActivity
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        btn_service.setOnClickListener {
            ServiceActivity.starter(this)
        }
    }
}