package com.luocz.primerproyecto.EjerciciosClase.RecycleView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.R
//Es otro metodo separando el ViewHolder
class UserViewHolder2 (view: View): RecyclerView.ViewHolder(view) {
    val name: TextView
    val image: ImageView
    init {
        name=view.findViewById(R.id.tvuser)
        image=view.findViewById(R.id.ivLogo)

    }
}