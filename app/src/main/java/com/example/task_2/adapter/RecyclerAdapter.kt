package com.example.task_2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2.OnItemClickListener
import com.example.task_2.R
import com.example.task_2.model.RecyclerItem

class RecyclerAdapter(var itemViewList: List<RecyclerItem>, var listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder>() {
    class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTittle: TextView = itemView.findViewById(R.id.item_tittle)
        var itemDescription: TextView = itemView.findViewById(R.id.Description)
        var itemImg: AppCompatImageView = itemView.findViewById(R.id.item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val items: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return AdapterViewHolder(items)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.itemDescription.text = itemViewList[position].description
        holder.itemTittle.text = itemViewList[position].tittle
        holder.itemImg.setImageResource(itemViewList[position].img)
        ViewCompat.setTransitionName(holder.itemImg, itemViewList[position].tittle);
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(itemViewList[position], holder.itemImg)
        })
    }

    override fun getItemCount(): Int {
        return itemViewList.size
    }
}