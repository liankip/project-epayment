package com.example.app_project.model

data class Menu(var title: String, var description: String, var Image: Int) {
    constructor(): this("", "",  0)
}