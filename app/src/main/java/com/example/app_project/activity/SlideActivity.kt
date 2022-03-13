package com.example.app_project.activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.app_project.databinding.ActivitySlideBinding

class SlideActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivitySlideBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initSlide()
    }

    private fun initSlide() {
        bundle = intent.extras

                val uri: Uri = Uri.parse(bundle?.getString("image_banner"))

        Glide.with(this).load(uri).override(800, 400).into(binding.slideImage);
//        binding.bannerImage?.setImageURI(uri)
        binding.slideTitle.text = bundle?.getString("banner_title")
        binding.slideContent.text = bundle?.getString("banner_desc")
    }
}