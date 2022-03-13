package com.example.app_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_project.R
import com.example.app_project.model.Pulsa
import com.google.android.material.card.MaterialCardView

class PulsaAdapter(val context: Context): RecyclerView.Adapter<PulsaAdapter.PulsaViewHolder>() {
    private val pulsa : MutableList<Pulsa> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PulsaViewHolder {
        return PulsaViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pulsa, parent, false))
    }

    override fun onBindViewHolder(holder: PulsaViewHolder, position: Int) {
        holder.bindmodel(pulsa[position])
    }

    override fun getItemCount() = pulsa.size

    fun setPulsa(item: List<Pulsa>) {
        pulsa.clear()
        pulsa.addAll(item)
        notifyDataSetChanged()
    }

    inner class PulsaViewHolder (item: View): RecyclerView.ViewHolder(item) {

        private val pulsaTitle: TextView = item.findViewById(R.id.pulsa_title)
        private val pulsaDetail: MaterialCardView = item.findViewById(R.id.pulsa_detail)

        fun bindmodel(pulsa: Pulsa) {
            pulsaTitle.text = pulsa.title

            pulsaDetail.setOnClickListener(View.OnClickListener {
                pulsaDetail.toggle()
            })
        }
    }


}