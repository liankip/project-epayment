package com.example.app_project.lib

import java.text.NumberFormat
import java.util.*

fun Any.convertRupiah(): String {
    val localId = Locale("in", "ID")
    val formatter = NumberFormat.getCurrencyInstance(localId)
    return formatter.format(this).toString()
}