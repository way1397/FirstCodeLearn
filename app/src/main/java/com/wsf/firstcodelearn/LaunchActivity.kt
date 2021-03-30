package com.wsf.firstcodelearn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.wsf.firstcodelearn.myjetpack.JetPackMainActivity
import com.wsf.firstcodelearn.service.ServiceActivity
import com.wsf.firstcodelearn.webviewtest.ProductDetailActivity

class LaunchActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var btn_service: Button
    private lateinit var btn_jetpack: Button
    private lateinit var testView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        toolbar = findViewById(R.id.toolbar)
        btn_service = findViewById(R.id.btn_service)
        btn_jetpack = findViewById(R.id.btn_jetpack)
        testView = findViewById(R.id.testView)
        setSupportActionBar(toolbar)
        btn_service.setOnClickListener {
            ServiceActivity.starter(this)
        }
        btn_jetpack.setOnClickListener {
            JetPackMainActivity.starter(this)
        }
        testView.setOnClickListener {
//            MyWebViewActivity.start(this)
//            ProductDetailActivity.start(this)
            SpreadActivity.start(this)

        }
//        btn_jetpack.setOnClickListener {
//            PermissionW.request(this, Manifest.permission.CALL_PHONE) { allGranted, deniedList ->
//                if (allGranted) {
//                    call()
//                } else {
//                    Toast.makeText(this, "You denied ${deniedList}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }

    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}