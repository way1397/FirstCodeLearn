package com.wsf.firstcodelearn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("data1", data1)
                putExtra("data2", data2)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val a = intent.getStringExtra("extra_data")
        Log.e("secondActivity", a ?: "a为空")
        tv_return.setOnClickListener {
            val intentReturn = Intent()
            intentReturn.putExtra("data_return", "Hello firstActivity")
            setResult(RESULT_OK, intentReturn)
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        val intent = Intent()

    }
}
