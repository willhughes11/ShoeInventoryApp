package com.example.shoestore.screens.shoe_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeDetailsFragmentBinding
import com.example.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    lateinit var viewModel: ShoeDetailsViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<ShoeDetailsFragmentBinding>(inflater, R.layout.shoe_details_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeDetailsViewModel::class.java)

        binding.lifecycleOwner = this
        binding.save.setOnClickListener {

            binding.shoeDetails = Shoe(
                    binding.shoeName.text.toString(),
                    binding.shoeSize.text.toString(),
                    binding.companyName.text.toString(),
                    binding.description.text.toString()
            )

            val s = binding.shoeDetails
            viewModel.saveCurrentDetail(s)
            view?.findNavController()?.navigate(R.id.action_shoe_details_to_shoe_listings)
        }


        binding.cancel.setOnClickListener {

            view?.findNavController()?.navigate(R.id.action_shoe_details_to_shoe_listings)
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_details_header)
        return binding.root
    }

}