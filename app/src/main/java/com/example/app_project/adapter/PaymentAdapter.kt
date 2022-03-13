package com.example.app_project.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_project.R
import com.example.app_project.model.Payment
import com.google.android.material.card.MaterialCardView

class PaymentAdapter(val context: Context): RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    private val payments : MutableList<Payment> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        return PaymentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_payment, parent, false))
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        holder.bindmodel(payments[position])
    }

    override fun getItemCount() = payments.size

    fun setPayment(item: List<Payment>) {
        payments.clear()
        payments.addAll(item)
    }

    inner class PaymentViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val payTitle: TextView = item.findViewById(R.id.payment_title)
        private val payDesc: TextView = item.findViewById(R.id.payment_description)
        private val paySelect: MaterialCardView = item.findViewById(R.id.paymentSelected)

        @SuppressLint("ResourceAsColor")
        fun bindmodel(payment: Payment) {
            payTitle.text = payment.title
            payDesc.text = payment.description
            paySelect.setOnClickListener(View.OnClickListener {
                paySelect.toggle()
            })
        }
    }
}