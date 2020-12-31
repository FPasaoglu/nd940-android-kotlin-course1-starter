package com.udacity.shoestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val username: String, val email: String, val phone: String, val password: String) : Parcelable
