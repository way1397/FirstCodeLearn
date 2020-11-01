package com.wsf.firstcodelearn.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.activity_notification_main.*

class NotificationMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_main)
        // 创建频道
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val channel = NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        // 创建通知
        btn_notification.setOnClickListener {
            val notification = NotificationCompat.Builder(this, "normal")
                    .setContentTitle("this is content title")
                    .setContentText("this is content text")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                    // 自动消失
                    .setAutoCancel(true)
                    .build()
            manager.notify(1, notification)
        }

        // 另一种取消通知的方法
//        val manager2 = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        manager.cancel(1)
    }
}