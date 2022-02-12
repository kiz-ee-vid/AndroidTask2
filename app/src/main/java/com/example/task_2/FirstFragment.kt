package com.example.task_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2.adapter.RecyclerAdapter
import com.example.task_2.databinding.FirstFragmentBinding
import com.example.task_2.model.RecyclerItem
import java.util.ArrayList

class FirstFragment : Fragment(), OnItemClickListener {

    private lateinit var binding: FirstFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FirstFragmentBinding.inflate(inflater)
        if (itemViewList.isEmpty())
            for (i in 1..1000) {
                itemViewList += (RecyclerItem(
                    "Tittle $i",
                    "Description $i",
                    R.drawable.ic_item_img
                ))
            }
        val recyclerView = binding.list
        val adapter = RecyclerAdapter(itemViewList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

    companion object {
        fun newInstance() = FirstFragment()
        val itemViewList: MutableList<RecyclerItem> = ArrayList<RecyclerItem>().toMutableList()
    }

    override fun onItemClick(item: RecyclerItem, itemImg: AppCompatImageView) {
        val ma: MainActivity = activity as MainActivity
        ma.onItemClick(item, itemImg)
    }
}