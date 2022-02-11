package com.example.task_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_2.adapter.Adapter
import com.example.task_2.databinding.FragmentBlankBinding
import com.example.task_2.model.ItemView
import java.util.ArrayList

class BlankFragment : Fragment(), OnItemClickListener {

    private lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        itemViewList.clear()
        for (i in 1..1000){
            itemViewList+=(ItemView("Tittle $i", "Description $i", R.drawable.ic_item_img))
        }
        val recyclerView: RecyclerView = binding.spisok
        val adapter: Adapter = Adapter(itemViewList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }

    companion object {
        fun newInstance() = BlankFragment()
        val itemViewList: MutableList<ItemView> = ArrayList<ItemView>().toMutableList()
    }

    override fun onItemClick(item: ItemView) {
        val ma: MainActivity = activity as MainActivity
        ma.onItemClick(item)
    }
}