package com.example.task_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task_2.databinding.ActivityMainBinding
import com.example.task_2.model.ItemView

class MainActivity : AppCompatActivity(), OnItemClickListener{
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createFirstFragment()
    }

    override fun onItemClick(item: ItemView) {
        createSecondFragment(item)
    }

    fun createFirstFragment(){
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, BlankFragment.newInstance())
            .commit()
    }

    private fun createSecondFragment(item: ItemView){
        val secondFragment = BlankFragment2.newInstance(item)
        supportFragmentManager
            .beginTransaction().replace(R.id.placeHolder, secondFragment)
            .addToBackStack("null")
            .commit()
    }
}