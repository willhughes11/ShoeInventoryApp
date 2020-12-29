package com.example.shoestore.screens.shoe_details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeDetailsFragmentBinding
import com.example.shoestore.screens.shoe_listings.ShoeListingsViewModel
import com.example.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    private val shoesViewModel: ShoeListingsViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: ShoeDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_details_fragment, container, false)
        binding.lifecycleOwner = this
        binding.shoeListingsViewModel = shoesViewModel
        binding.shoe = Shoe()

        binding.save.setOnClickListener {
            shoesViewModel.addShoe(shoesViewModel.shoe)
            view?.findNavController()?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeListings())
        }

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeListings())
        }

        return binding.root
    }

}