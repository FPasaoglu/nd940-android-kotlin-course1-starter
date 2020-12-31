package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.utils.shortLengthToastText
import com.udacity.shoestore.viewModel.UserViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    val viewModel by activityViewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.userViewModel = viewModel
        binding.lifecycleOwner = this

        binding.textViewSignup.setOnClickListener {
            requireView().findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

        binding.buttonLogin.setOnClickListener {
            if (viewModel.isLoginSuccess()) {
                requireView().findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(viewModel.getUser()))
                viewModel.clearUser()
            } else {
                requireContext().shortLengthToastText(getString(R.string.incorrect_login))
            }
        }

        return binding.root
    }

}