package org.pondar.jetpackexamplekotlin.ui.loggedin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.logged_in_fragment.*
import org.pondar.jetpackexamplekotlin.R
import org.pondar.jetpackexamplekotlin.ui.home.HomeViewModel

class LoggedInFragment : Fragment() {

    companion object {
        fun newInstance() = LoggedInFragment()
    }

    private lateinit var viewModel: LoggedInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.logged_in_fragment, container, false)
    }

    val args: LoggedInFragmentArgs by navArgs()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoggedInViewModel::class.java)
        // TODO: Use the ViewModel
        Log.d("LoggedInFragment", "user = ${args.user}")
        logged_in_textview.text = "Logged in as ${args.user.fullName} with email: ${args.user.email}"



    }

}