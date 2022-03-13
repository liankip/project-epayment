package com.example.app_project.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app_project.R
import com.example.app_project.activity.PulsaActivity
import com.example.app_project.model.Menu
import com.google.android.material.card.MaterialCardView

class MenuAdapter(val context: Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val menus : MutableList<Menu> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bindModel(menus[position])
    }

    override fun getItemCount() = menus.size

    fun setMenu(data: List<Menu>) {
        menus.clear()
        menus.addAll(data)
    }

    inner class MenuViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val menuTitle: TextView = item.findViewById(R.id.menu_title)
        private val menuDesc: TextView = item.findViewById(R.id.menu_desc)
        private val menuImg: ImageView = item.findViewById(R.id.menu_image)
        private val menuDetail: MaterialCardView = item.findViewById(R.id.menuDetail)

        fun bindModel(menu: Menu) {
            menuTitle.text = menu.title
            menuDesc.text = menu.description
            menuImg.setImageResource(menu.Image)

            menuDetail.setOnClickListener {
                when (adapterPosition.toString()) {
                    "0" -> {
                        val i = Intent(context, PulsaActivity::class.java)
                        i.putExtra("menu_title", menu.title)
                        i.putExtra("menu_description", menu.description)
                        context.startActivity(i)
                    }
                    "1" -> {
                        Toast.makeText(context, "under construction", Toast.LENGTH_SHORT).show()
                    }
                    "2" -> {
                        Toast.makeText(context, "under construction", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}