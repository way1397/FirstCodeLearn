package com.wsf.firstcodelearn.database

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.wsf.firstcodelearn.R
import kotlinx.android.synthetic.main.activity_data_main.*
import java.lang.Exception
import java.lang.NullPointerException

class DatabaseMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_main)
        val dbHelp = DatabaseHelper(this, "BookStore.db", 3)
        bt_create_db.setOnClickListener {
            dbHelp.writableDatabase
        }

        bt_add_data.setOnClickListener {
            val db = dbHelp.writableDatabase
            val values1 = ContentValues().apply {
                put("name", "the da vinci code")
                put("author", "dan brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book", null, values1)
            val values2 = ContentValues().apply {
                put("name", "the lost symbol")
                put("author", "dan brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2)
        }

        bt_update_data.setOnClickListener {
            val db = dbHelp.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name=?", arrayOf("the da vinci code"))
        }

        bt_delete_data.setOnClickListener {
            val db = dbHelp.writableDatabase
            db.delete("Book", "pages>?", arrayOf("500"))
        }

        bt_query_data.setOnClickListener {
            val db = dbHelp.writableDatabase
//            val cursor = db.query("Book", null, null, null, null, null, null)
            val cursor = db.rawQuery("select * from Book", null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getString(cursor.getColumnIndex("pages"))
                    val price = cursor.getString(cursor.getColumnIndex("price"))
                    Log.d("databadaMain", "Book name is $name ")
                    Log.d("databadaMain", "Book author is $author ")
                    Log.d("databadaMain", "Book pages is $pages ")
                    Log.d("databadaMain", "Book price is $price ")
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        bt_replace_data.setOnClickListener {
            val db = dbHelp.writableDatabase
            db.beginTransaction()
            try {
                db.delete("Book", null, null)
//                if (true) {
//                    throw NullPointerException()
//                }
                val values = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "Game of thrones")
                    put("pages", 720)
                    put("price", 20.85)
                }
                db.insert("Book", null, values)
                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}