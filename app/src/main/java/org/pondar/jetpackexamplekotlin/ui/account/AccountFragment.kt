package org.pondar.jetpackexamplekotlin.ui.account

import android.R.attr.data
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.pondar.jetpackexamplekotlin.R
import org.pondar.jetpackexamplekotlin.databinding.FragmentAccountBinding
import org.pondar.jetpackexamplekotlin.ui.loggedin.LoggedInFragment


class AccountFragment : Fragment() {

    private lateinit var viewmodel: AccountViewModel
    private lateinit var binding : FragmentAccountBinding



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        viewmodel =
                ViewModelProvider(this).get(AccountViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account,container,false)
        binding.vm = viewmodel
        val view = binding.root


        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        viewmodel.loginOkay.observe(viewLifecycleOwner, Observer {
            if (it==true)
            {
                //without any parameters just use the ID
               // findNavController().navigate(R.id.action_nav_account_to_loggedInFragment

                Log.d("user login",viewmodel.user.toString())
                val action = AccountFragmentDirections.actionNavAccountToLoggedInFragment(viewmodel.user)
                findNavController().navigate(action)
                //with parameters use the two lines above
            }
        })

        super.onActivityCreated(savedInstanceState)
    }

}