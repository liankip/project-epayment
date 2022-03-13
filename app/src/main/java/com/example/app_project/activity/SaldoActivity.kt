package com.example.app_project.activity

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_project.MainActivity
import com.example.app_project.adapter.PaymentAdapter
import com.example.app_project.databinding.ActivitySaldoBinding
import com.example.app_project.model.Payment

class SaldoActivity : AppCompatActivity() {

    var bundle : Bundle? = null
    private val binding by lazy { ActivitySaldoBinding.inflate(layoutInflater) }

    private lateinit var paymentAdapter: PaymentAdapter
    private val listPayment = LinearLayoutManager(this)
    private val addPaymentList: MutableList<Payment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bundle = intent.extras

        this.supportActionBar?.title = bundle?.getString("title_saldo")

        binding.btnCancel.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        binding.btnAdd.setOnClickListener {
            val i = Intent(this, FinishActivity::class.java)
            startActivity(i)
        }

        initPayment()
    }

    private fun initPayment() {
        binding.rvPayment.layoutManager = listPayment
        paymentAdapter = PaymentAdapter(this)
        binding.rvPayment.adapter = paymentAdapter

        addPaymentList.add(Payment("ATM","Pembayaran di atm bca, mandiri dan bri"))
        addPaymentList.add(Payment("Internet Banking","Pembayaran di internet banking bca, mandiri dan bri"))
        addPaymentList.add(Payment("Minimarket","Pembayaran di minimarket alfamart"))

        paymentAdapter.setPayment(addPaymentList)
    }
}