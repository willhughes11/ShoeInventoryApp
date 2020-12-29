package com.example.shoestore.screens.login

import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.shoestore.R
import com.example.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        binding.login.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginToWelcome()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }
}