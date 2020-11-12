package com.wsf.firstcodelearn.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {

    lateinit var downloadBinder: MyService.DownloadBinder

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }


    }

    companion object {
        fun starter(context: Context) {
            val intent = Intent(context, ServiceActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        btn_start_service.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
        }
        btn_end_service.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
        btn_bind_service.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
        btn_unbind_service.setOnClickListener {
            unbindService(connection)
        }
        btn_intent_service.setOnClickListener {
            Log.d("LauncherActivity", "Thread is ${Thread.currentThread().name} ")
            val intent = Intent(this, MyIntentService::class.java)
            startService(intent)
        }
    }
}