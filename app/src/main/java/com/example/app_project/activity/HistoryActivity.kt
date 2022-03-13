package com.example.app_project.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.app_project.R
import com.example.app_project.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivityHistoryBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initHistory()
    }

    @SuppressLint("SetTextI18n")
    private fun initHistory() {
        bundle = intent.extras

        binding.historyId.text = bundle?.getString("history_id")
        binding.historyProduct.text = bundle?.getString("history_product")
        binding.historySubtotal.text = bundle?.getString("history_subtotal")
        binding.historyAdmin.text = bundle?.getString("history_admin")
        binding.historyTotal.text = bundle?.getString("history_total")

        when (bundle?.getString("history_status")) {
            "0" -> {
                binding.historyStatus.text = "Berhasil"
                binding.historyStatus.setTextColor(ContextCompat.getColor(this, R.color.green_500))
            }
            "1" -> {
                binding.historyStatus.text = "Pending"
                binding.historyStatus.setTextColor(ContextCompat.getColor(this, R.color.blue_gray_500))
            }
            "2" -> {
                binding.historyStatus.text = "Gangguan"
                binding.historyStatus.setTextColor(ContextCompat.getColor(this, R.color.orange_500))
            }
            "3" -> {
                binding.historyStatus.text = "Gagal"
                binding.historyStatus.setTextColor(ContextCompat.getColor(this, R.color.red_500))
            }
        }
    }
}