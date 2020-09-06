package com.wsf.firstcodelearn.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyNewBroadReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "MyNewBroadReceiver收到标准广播", Toast.LENGTH_LONG).show()
    }
}