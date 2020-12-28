package com.example.shoestore.screens.instructions

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    companion object {
        fun newInstance() = InstructionsFragment()
    }

    private lateinit var viewModel: InstructionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)
        binding.instructionsNextButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsToShoeListings())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}