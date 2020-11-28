package com.wsf.firstcodelearn.myjetpack

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.activity_jetpack_main.*

class JetPackMainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    companion object {
        fun starter(context: Context) {
            val intent = Intent(context, JetPackMainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_main)
        lifecycle.addObserver(MyObserver(lifecycle))
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProvider(this, MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        viewModel.counter.observe(this, Observer { count -> tv_count.text = count.toString() })
        btn_clean.setOnClickListener {
            viewModel.clear()
        }
        btn_count.setOnClickListener {
            viewModel.plusOne()
        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }

    private fun refreshCounter() {
        tv_count.text = viewModel.counter.toString()
    }
}