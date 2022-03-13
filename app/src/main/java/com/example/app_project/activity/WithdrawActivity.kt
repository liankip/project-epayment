package com.example.app_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_project.MainActivity
import com.example.app_project.databinding.ActivityWithdrawBinding

class WithdrawActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivityWithdrawBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bundle = intent.extras

        this.supportActionBar?.title = bundle?.getString("title_withdraw")

        binding.btnCancel.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        binding.btnTransfer.setOnClickListener {
            val i = Intent(this, FinishActivity::class.java)
            startActivity(i)
        }
    }
}