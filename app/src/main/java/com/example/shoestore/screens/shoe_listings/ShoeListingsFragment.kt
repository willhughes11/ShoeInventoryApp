package com.example.shoestore.screens.shoe_listings

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeListingsFragmentBinding
import com.example.shoestore.models.Shoe

class ShoeListingsFragment : Fragment() {

    private val shoeListingsViewModel: ShoeListingsViewModel by activityViewModels()
    private lateinit var binding: ShoeListingsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_listings_fragment, container, false)
        binding.lifecycleOwner = this

        shoeListingsViewModel.getShoeLiveData().observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                createShoes(it)
            }
        })

        binding.fab.setOnClickListener {
            view?.findNavController()?.navigate(ShoeListingsFragmentDirections.actionShoeListingsToShoeDetails())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }
}