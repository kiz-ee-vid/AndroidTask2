package com.example.task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import com.example.task_2.databinding.ActivityMainBinding
import com.example.task_2.model.RecyclerItem

class MainActivity : AppCompatActivity(), OnItemClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null)
            createFirstFragment()
    }

    override fun onItemClick(item: RecyclerItem, itemImg: AppCompatImageView) {
        createSecondFragment(item, itemImg)
    }

    private fun createFirstFragment() {
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, FirstFragment.newInstance())
            .commit()
    }

    private fun createSecondFragment(item: RecyclerItem, itemImg: AppCompatImageView) {
        val secondFragment = SecondFragment.newInstance(item)
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, secondFragment)
            .addSharedElement(itemImg, ViewCompat.getTransitionName(itemImg)!!)
            .addToBackStack("null")
            .commit()
    }
}