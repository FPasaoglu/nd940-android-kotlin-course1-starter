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
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.utils.shortLengthToastText
import com.udacity.shoestore.viewModel.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.userViewModel = viewModel
        binding.lifecycleOwner = this


        binding.buttonCancel.setOnClickListener {
            requireView().findNavController().popBackStack()
            viewModel.clearShoe()
        }


        binding.buttonSave.setOnClickListener {
            viewModel.apply {
                when (checkIsNotBlank()) {
                    ShoeViewModel.StatusShoe.SUCCESS -> {
                        addShoe()
                        requireContext().shortLengthToastText(getString(R.string.success))
                        requireView().findNavController().popBackStack()
                    }
                    ShoeViewModel.StatusShoe.INCORRECT_SIZE_TYPE -> requireContext().shortLengthToastText(
                        getString(R.string.incorrect_type)
                    )
                    ShoeViewModel.StatusShoe.FAIL -> requireContext().shortLengthToastText(
                        getString(
                            R.string.fail_fill_all_blank
                        )
                    )
                }
            }
        }

        return binding.root
    }


}