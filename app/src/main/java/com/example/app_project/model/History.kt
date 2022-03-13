package com.example.app_project.model

data class History(val id: Int, val produk: String, val tujuan: Long, val harga: Int, val komisi: Int, val status: Int) {
    constructor(): this(0, "",  0, 0, 0, 0)
}