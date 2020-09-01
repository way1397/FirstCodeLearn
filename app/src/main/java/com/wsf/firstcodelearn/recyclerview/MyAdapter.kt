package com.wsf.firstcodelearn.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wsf.firstcodelearn.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    val ListString = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        val viewHolder = MyHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
    }

    public class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)
        val iv_head = itemView.findViewById<ImageView>(R.id.iv_head)

    }
}