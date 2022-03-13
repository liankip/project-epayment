package com.example.app_project.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_project.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivityInfoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initInfo()
    }

    private fun initInfo() {
        bundle = intent.extras

        binding.infoTitle.text = bundle?.getString("info_title")
        binding.infoDesc.text = bundle?.getString("info_desc")
        binding.infoContent.text = bundle?.getString("info_cont")
    }
}