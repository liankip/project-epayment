package com.example.app_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app_project.MainActivity
import com.example.app_project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        this.supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            val number = binding.loginNumber.text.toString()
            val pin = binding.loginPin.text.toString()

            if (number.isEmpty() || pin.isEmpty()) {
                Toast.makeText(this, "Masukkan nomor handphone dan pin", Toast.LENGTH_LONG).show()

            } else if (number == "081267582824" && pin == "123123") {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)

            } else
                Toast.makeText(this, "Akun yang anda masukkan tidak ada", Toast.LENGTH_LONG).show()
        }

        binding.btnRegister.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}