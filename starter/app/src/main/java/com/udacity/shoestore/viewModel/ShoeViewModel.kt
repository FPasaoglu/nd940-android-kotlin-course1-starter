package com.udacity.shoestore.viewModel

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {


    enum class StatusShoe {
        SUCCESS,
        INCORRECT_SIZE_TYPE,
        FAIL
    }

    private val shoeListDataBase = mutableListOf<Shoe>(
        Shoe(
            "Dockers",
            8.5,
            "DEICHMANN",
            "Our company is specialized in different kinds of products. We stick to the principle of \"quality first, service first, continuous improvement and innovation to meet the customers\" for the management and \"zero defect, zero complaints\" as the quality objective. To perfect our service, we make our products with good quality at the reasonable price."
        ),
        Shoe(
            "AirJordan",
            6.0,
            "NIKE",
            "Our company is specialized in different kinds of products. We stick to the principle of \"quality first, service first, continuous improvement and innovation to meet the customers\" for the management and \"zero defect, zero complaints\" as the quality objective. To perfect our service, we make our products with good quality at the reasonable price."
        ),
        Shoe(
            "Superstar",
            9.5,
            "ADIDAS",
            "Our company is specialized in different kinds of products. We stick to the principle of \"quality first, service first, continuous improvement and innovation to meet the customers\" for the management and \"zero defect, zero complaints\" as the quality objective. To perfect our service, we make our products with good quality at the reasonable price."
        ),
        Shoe(
            "Classic",
            8.0,
            "PUMA",
            "Our company is specialized in different kinds of products. We stick to the principle of \"quality first, service first, continuous improvement and innovation to meet the customers\" for the management and \"zero defect, zero complaints\" as the quality objective. To perfect our service, we make our products with good quality at the reasonable price."
        )
    )

    var shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = shoeListDataBase
    }

    var name = String()
    var size = String()
    var company = String()
    var desc = String()

    fun addShoe() {
        shoeListDataBase.add(getShoe())
    }

    fun checkIsNotBlank(): StatusShoe {

        val status =
            if (name.isNotBlank() && size.isNotBlank() && company.isNotBlank() && desc.isNotBlank()) {
                if (size.toDouble() > 0.0 && size.toDouble() <= 18.0) {
                    StatusShoe.SUCCESS
                } else StatusShoe.INCORRECT_SIZE_TYPE
            } else {
                StatusShoe.FAIL
            }

        return status
    }

    fun getShoe(): Shoe {
        return Shoe(name, size.toDouble(), company, desc)
    }

}