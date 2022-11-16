package com.luocz.primerproyecto.EjerciciosClase.Almacenamiento

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.R

class UserSQLModelHolder(view: View) : RecyclerView.ViewHolder(view) {
    val id: TextView
    val name: TextView
    val description: TextView

    init {
        id = view.findViewById(R.id.tvId)
        name = view.findViewById(R.id.tvUser)
        description = view.findViewById(R.id.tvDescription)
    }

}
