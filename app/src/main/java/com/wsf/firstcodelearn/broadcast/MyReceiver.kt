package com.wsf.firstcodelearn.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * 自定义广播
 */
class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "收到标准广播", Toast.LENGTH_LONG).show()
        // 优先级高的广播可以截断广播让优先级低的广播收不到
        abortBroadcast()
    }
}