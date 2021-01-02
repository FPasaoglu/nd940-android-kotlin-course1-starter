package com.udacity.shoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    val isChecked = MutableLiveData<Boolean>()

}