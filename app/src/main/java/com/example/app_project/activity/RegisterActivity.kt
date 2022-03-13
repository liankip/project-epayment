package com.example.app_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app_project.R
import com.example.app_project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        binding.btnCancel.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        binding.btnRegister.setOnClickListener {

            val number = binding.registerNumber.text.toString()
            val pin = binding.registerPin.text.toString()

            if (number.isEmpty() || pin.isEmpty()) {
                Toast.makeText(this, "Data masih kosong", Toast.LENGTH_SHORT).show()

            } else if (number.isNotEmpty() || pin.isNotEmpty()) {
                Toast.makeText(this, "Akun berhasil terdaftar", Toast.LENGTH_SHORT).show()
                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
        }
    }
}