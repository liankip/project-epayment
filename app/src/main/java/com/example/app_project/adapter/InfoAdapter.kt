package com.example.app_project.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_project.R
import com.example.app_project.activity.InfoActivity
import com.example.app_project.model.Info
import com.google.android.material.card.MaterialCardView

class InfoAdapter(val context: Context): RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {
    private val infos : MutableList<Info> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoAdapter.InfoViewHolder {
        return InfoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_info, parent, false))
    }

    override fun onBindViewHolder(holder: InfoAdapter.InfoViewHolder, position: Int) {
        holder.bindmodel(infos[position])
    }

    override fun getItemCount() = infos.size

    fun setInfo(item: List<Info>) {
        infos.clear()
        infos.addAll(item)
    }

    inner class InfoViewHolder (item: View): RecyclerView.ViewHolder(item) {

        private val infoTitle: TextView = item.findViewById(R.id.info_title)
        private val infoDesc: TextView = item.findViewById(R.id.info_description)
        private val infoDetail: MaterialCardView = item.findViewById(R.id.infoDetail)

        fun bindmodel(info: Info) {
            infoTitle.text = info.title
            infoDesc.text = info.description

            infoDetail.setOnClickListener {
                val i = Intent(context, InfoActivity::class.java)
                i.putExtra("info_title", info.title)
                i.putExtra("info_desc", info.description)
                i.putExtra("info_cont", info.content)
                context.startActivity(i)
            }
        }
    }
}