package com.example.app_project.model

data class Payment(var title: String, var description: String) {
    constructor(): this("", "")
}