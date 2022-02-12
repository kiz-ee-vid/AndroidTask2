package com.example.task_2

import androidx.appcompat.widget.AppCompatImageView
import com.example.task_2.model.RecyclerItem

interface OnItemClickListener {
    fun onItemClick(item: RecyclerItem, itemImg: AppCompatImageView)
}