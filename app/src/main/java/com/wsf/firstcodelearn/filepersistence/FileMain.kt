package com.wsf.firstcodelearn.filepersistence

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import com.wsf.firstcodelearn.kotlinlearn.open
import kotlinx.android.synthetic.main.activity_file_main.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class FileMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_main)
        val inputText = load()
        if (inputText.isNotEmpty()) {
            et_file.setText(inputText)
            et_file.setSelection(inputText.length)
        }
        getSharedPreferences("data", Context.MODE_PRIVATE).open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        val input = et_file.text.toString()
        save(input)
    }

    private fun save(inputText: String) {
        try {
            val output = openFileOutput("wsf_data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("wsf_data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return content.toString()
    }
}