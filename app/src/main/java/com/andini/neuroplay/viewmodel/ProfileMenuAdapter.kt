package com.andini.neuroplay.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.andini.neuroplay.R

class ProfileMenuAdapter(private val menuList: List<String>) : RecyclerView.Adapter<ProfileMenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_menu_profile, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuName = menuList[position]
        holder.bind(menuName)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuNameTextView: TextView = itemView.findViewById(R.id.menuName)

        fun bind(menuName: String) {
            menuNameTextView.text = menuName

            if (menuName == "Logout") {
                val drawable = ContextCompat.getDrawable(itemView.context, R.drawable.ic_logout)
                if (drawable != null) {
                    val wrappedDrawable = DrawableCompat.wrap(drawable)
                    DrawableCompat.setTint(wrappedDrawable, ContextCompat.getColor(itemView.context, R.color.orange))
                    menuNameTextView.setCompoundDrawablesWithIntrinsicBounds(wrappedDrawable, null, null, null)
                }
                menuNameTextView.setTextColor(ContextCompat.getColor(itemView.context, R.color.orange))
            }else if (menuName == "Edit Password") {
                menuNameTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_password, 0, 0, 0)
            }

        }
    }
}