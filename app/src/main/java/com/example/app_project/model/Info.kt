package com.example.app_project.model

data class Info(var title: String, var description: String, var content: String) {
    constructor(): this("", "",  "")
}