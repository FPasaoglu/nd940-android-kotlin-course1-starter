package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    val args by navArgs<WelcomeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater, R.layout.fragment_welcome, container, false)

        binding.textViewName.text = args.userItem.username
        binding.textViewPhoneNumber.text = args.userItem.phone

        binding.buttonActionToShoeListFragment.setOnClickListener {
            requireView().findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            )
        }

        return binding.root
    }

}