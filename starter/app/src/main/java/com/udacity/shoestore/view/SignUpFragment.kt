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
import com.udacity.shoestore.databinding.FragmentSignUpBinding
import com.udacity.shoestore.utils.shortLengthToastText
import com.udacity.shoestore.viewModel.UserViewModel

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    val viewModel by activityViewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        binding.userViewModel = viewModel
        binding.lifecycleOwner = this


        binding.buttonLogin.setOnClickListener {
            if (viewModel.isSignUpSuccess()) {
                requireView().findNavController().navigate(
                    SignUpFragmentDirections.actionSignUpFragmentToWelcomeFragment(viewModel.getUser())
                )
                viewModel.clearUser()
            } else {
                requireContext().shortLengthToastText(getString(R.string.incorrect_signup))
            }
        }
        return binding.root
    }

}