package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.viewModel.InstructionViewModel


class InstructionFragment : Fragment() {

    val viewModel by activityViewModels<InstructionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this


        binding.buttonToShoeList.setOnClickListener {
            it.findNavController().navigate(
                InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
            )
        }


        return binding.root
    }

}