package com.example.shoestore.screens.shoe_listings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoeListingsFragmentBinding
import com.example.shoestore.screens.shoe_details.ShoeAdapter
import com.example.shoestore.screens.shoe_details.ShoeDetailsViewModel

class ShoeListingsFragment : Fragment() {
    private lateinit var binding: ShoeListingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_listings_fragment, container, false)

        setHasOptionsMenu(true)

        binding.fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoe_listings_to_shoe_details))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(ShoeDetailsViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, { list ->
            val adapter = ShoeAdapter(list)
            binding.list.adapter = adapter
        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_listings)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}