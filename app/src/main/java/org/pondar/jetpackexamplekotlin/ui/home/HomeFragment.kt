package org.pondar.jetpackexamplekotlin.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.pondar.jetpackexamplekotlin.R
import org.pondar.jetpackexamplekotlin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)

       val root = binding.root

        homeViewModel.data.observe(viewLifecycleOwner, {
            //"it" is the same as homeViewModel.data.value
            binding.textHome.text = it
            Log.d("observer","new value observed: $it")
        })
        homeViewModel.downloadFromServer()

        return root
    }
}