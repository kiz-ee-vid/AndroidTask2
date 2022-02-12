package com.example.task_2

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionInflater
import com.example.task_2.databinding.SecondFragmentBinding
import com.example.task_2.model.RecyclerItem

class SecondFragment : Fragment() {

    private lateinit var binding: SecondFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition =
                TransitionInflater.from(context).inflateTransition(android.R.transition.move);
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SecondFragmentBinding.inflate(inflater)
        binding.tittle.text = arguments!!.getString("tit")
        binding.description.text = arguments!!.getString("desc")
        binding.centralImage.setImageResource(arguments!!.getInt("img"))
        val transitionName = arguments!!.getString("tit")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.centralImage.transitionName = transitionName;
        }
        makeMenu()
        return binding.root
    }

    private fun makeMenu() {
        setHasOptionsMenu(true)
        val ma: AppCompatActivity = activity as AppCompatActivity
        ma.setSupportActionBar(binding.toolbar)
        ma.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                activity?.supportFragmentManager
                    ?.popBackStack()
            R.id.finish ->
                activity?.finish()
        }
        return true
    }

    companion object {
        fun newInstance(item: RecyclerItem): SecondFragment {
            val fragment = SecondFragment()
            val args = Bundle()
            args.putInt("img", item.img)
            args.putString("tit", item.tittle)
            args.putString("desc", item.description)
            fragment.arguments = args
            return fragment
        }
    }
}