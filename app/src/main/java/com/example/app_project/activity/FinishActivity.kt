package com.example.app_project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_project.R

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        this.supportActionBar?.hide()
    }
}