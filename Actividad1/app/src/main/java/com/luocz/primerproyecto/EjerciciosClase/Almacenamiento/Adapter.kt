package com.luocz.primerproyecto.EjerciciosClase.Almacenamiento

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.Ejercicio2.RecyclerItemAnimalListener
import com.luocz.primerproyecto.R

class Adapter(
    private val items: ArrayList<UserSQLModel>,
    private val listener: RecyclerItemUserListener
) : RecyclerView.Adapter<UserSQLModelHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSQLModelHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_user2, parent, false)
        return UserSQLModelHolder(view)
    }

    override fun onBindViewHolder(holder: UserSQLModelHolder, position: Int) {
        holder.id.text = items[position].id.toString()
        holder.name.text = items[position].name
        holder.description.text = items[position].description
        holder.itemView.setOnClickListener {
            listener.onItemSelected(items[position])
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems :ArrayList<UserSQLModel>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

