package com.wsf.firstcodelearn

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        initClick()
        if (savedInstanceState != null) {
            val tempdata = savedInstanceState.getString("data_key")
            Log.e(TAG, tempdata)
        }
    }

    private fun initClick() {
        tv_show_toast.setOnClickListener {
            Toast.makeText(this, "this is a toast", Toast.LENGTH_SHORT).show()
        }

        tv_go_second.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data", "hello secondActivity")
            startActivity(intent)
        }

        tv_start_dialog.setOnClickListener {
            var intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

        tv_show_dialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("this is Dialog")
                setMessage("something important")
                setCancelable(false)
                setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                setNegativeButton("cancel") { dialog, _ -> dialog.dismiss() }
                show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var tempdata = "Something you just type"
        outState.putString("data_key", tempdata)
    }

    fun logView(view: View?) {
        var viewid = view?.id
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val returnData = data?.getStringExtra("data_return")
                Log.e(TAG, "return data is $returnData")
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onReStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "add item", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "remove item", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}