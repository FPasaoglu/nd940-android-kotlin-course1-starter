package com.udacity.shoestore.view

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.*
import android.widget.TextView
import androidx.core.text.bold
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.model.Shoe
import com.udacity.shoestore.viewModel.ShoeViewModel

class ShoeListFragment : Fragment() {

    val viewModel by activityViewModels<ShoeViewModel>()

    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)


        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            for (shoe in shoeList) {
                binding.linearLayout.addView(createTextView(shoe))
            }
        })

        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener {
            requireView().findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        }

        return binding.root
    }

    private fun createTextView(shoe: Shoe): TextView {
        val texView = TextView(requireContext())

        val strb = SpannableStringBuilder()
            .bold { append(getString(R.string.name)) }
            .append(shoe.name + "\n")
            .bold { append(getString(R.string.size)) }
            .append(shoe.size.toString() + "\n")
            .bold { append(getString(R.string.company)) }
            .append(shoe.company + "\n")
            .bold { append(getString(R.string.description)) }
            .append(shoe.description + "\n\n")

        texView.text = strb
        return texView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.logoutOption -> logout()
        }

        return super.onOptionsItemSelected(item)
    }

    fun logout() {
        requireView().findNavController().navigate(
            ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        )
    }
}