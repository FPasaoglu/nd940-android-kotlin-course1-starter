package com.udacity.shoestore.utils

import android.content.Context
import android.widget.Toast

fun Context.shortLengthToastText(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.longLengthToastText(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}