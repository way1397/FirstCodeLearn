package com.wsf.firstcodelearn.thread

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.activity_thread.*
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {

    val updateText = 1

    val handle = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                updateText -> textView.text = "nice to meet you"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        btn_change.setOnClickListener {
            thread {
                val msg = Message()
                runOnUiThread {

                }
                msg.what = updateText
                handle.sendMessage(msg)
            }
        }
    }
}