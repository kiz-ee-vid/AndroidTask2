package com.example.task_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task_2.databinding.FragmentBlank2Binding
import com.example.task_2.databinding.FragmentBlankBinding
import com.example.task_2.model.ItemView

class BlankFragment2 : Fragment() {

    private lateinit var binding: FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        binding.tittle.text = arguments!!.getString("tit")
        binding.description.text = arguments!!.getString("desc")
        binding.imageView.setImageResource(arguments!!.getInt("img"))

        return binding.root
    }

    companion object {
        fun newInstance(item: ItemView): BlankFragment2 {
            val fragment = BlankFragment2()
            val args = Bundle()
            args.putInt("img", item.img)
            args.putString("tit", item.tittle)
            args.putString("desc", item.description)
            fragment.arguments = args
            return fragment
        }
    }
}