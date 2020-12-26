package com.example.shoestore.screens.shoe_listings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoestore.R

class ShoeListingsFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListingsFragment()
    }

    private lateinit var viewModel: ShoeListingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shoe_listings_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeListingsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}