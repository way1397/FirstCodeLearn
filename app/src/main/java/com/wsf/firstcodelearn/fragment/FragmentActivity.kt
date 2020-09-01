package com.wsf.firstcodelearn.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.avtivity_fragment.*

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avtivity_fragment)
        replaceFragment(LeftFragment())
        // 获取fragment1
        val fragment = supportFragmentManager.findFragmentById(R.id.top_fragment_container)
        // 获取fragment2
        val fragmen2=right_fragment as RightFragment
    }

    private fun replaceFragment(fragment: LeftFragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.top_fragment_container, fragment)
        // 返回栈，这样手机按下返回键，不会直接退出，会返回到上一个fragment，括号里参数是返回栈的名字，一般为null
        transaction.addToBackStack(null)
        transaction.commit()
    }
}