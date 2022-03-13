package com.example.app_project.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.app_project.R
import com.example.app_project.activity.HistoryActivity
import com.example.app_project.lib.convertRupiah
import com.example.app_project.model.History
import com.google.android.material.card.MaterialCardView

class HistoryAdapter(val context: Context): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val historys : MutableList<History> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history, parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bindmodel(historys[position])
    }

    fun setHistory(item: List<History>) {
        historys.clear()
        historys.addAll(item)
    }

    override fun getItemCount() = historys.count()

    inner class HistoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val hsProduct: TextView = item.findViewById(R.id.history_product)
        private val hsPrice: TextView = item.findViewById(R.id.history_price)
        private val hsStatus: TextView = item.findViewById(R.id.history_status)
        private val historyDetail: MaterialCardView = item.findViewById(R.id.historyDetail)

        @SuppressLint("SetTextI18n")
        fun bindmodel(history: History) {
            hsProduct.text = history.produk
            hsPrice.text = history.harga.convertRupiah()

            hsStatus.text = ""
            when (history.status) {
                0 -> {
                    hsStatus.text = "Berhasil"
                    hsStatus.setTextColor(ContextCompat.getColor(context, R.color.green_500))
                }
                1 -> {
                    hsStatus.text = "Pending"
                    hsStatus.setTextColor(ContextCompat.getColor(context, R.color.blue_gray_500))
                }
                2 -> {
                    hsStatus.text = "Gangguan"
                    hsStatus.setTextColor(ContextCompat.getColor(context, R.color.orange_500))
                }
                3 -> {
                    hsStatus.text = "Gagal"
                    hsStatus.setTextColor(ContextCompat.getColor(context, R.color.red_500))
                }
            }

            historyDetail.setOnClickListener {
                val i = Intent(context, HistoryActivity::class.java)
                i.putExtra("history_id", history.id.toString())
                i.putExtra("history_product", history.produk)
                i.putExtra("history_subtotal", (history.harga - 1500).convertRupiah())
                i.putExtra("history_admin", 1500.convertRupiah())
                i.putExtra("history_total", history.harga.convertRupiah())
                i.putExtra("history_status", history.status.toString())

                context.startActivity(i)
            }
        }
    }
}