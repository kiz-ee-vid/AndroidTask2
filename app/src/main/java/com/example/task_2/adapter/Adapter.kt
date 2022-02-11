package com.example.task_2.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2.OnItemClickListener
import com.example.task_2.R
import com.example.task_2.model.ItemView

class Adapter(var itemViewList: List<ItemView>, var listener: OnItemClickListener):
    RecyclerView.Adapter<Adapter.AdapterViewHolder>() {
    class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTittle: TextView = itemView.findViewById(R.id.item_tittle)
        var itemDescription: TextView = itemView.findViewById(R.id.Description)
        var itemImg: AppCompatImageView = itemView.findViewById(R.id.item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val courseItems: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return AdapterViewHolder(courseItems)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemDescription.text = itemViewList[position].description
        holder.itemTittle.text = itemViewList[position].tittle
        holder.itemImg.setImageResource(itemViewList[position].img)
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(itemViewList[position])
        })
    }

    override fun getItemCount(): Int {
        return itemViewList.size
    }
}