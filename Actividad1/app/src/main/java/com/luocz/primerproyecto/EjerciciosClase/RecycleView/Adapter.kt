package com.luocz.primerproyecto.EjerciciosClase.RecycleView

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.R

class Adapter(private val items : ArrayList<UserItem>): RecyclerView.Adapter<Adapter.UserViewHolder>() {
    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView
        val image: ImageView
        init {
            name=view.findViewById(R.id.tvuser)
            image=view.findViewById(R.id.ivLogo)

        }
    }
    //ASIGNA EL ITEM O LA CARD RELIZADA
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_user,parent,false)
        return UserViewHolder(view)
    }
    //RECILCARA CON LOS CARDS
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = items[position].name

    }
    //El numero de elementos total
    override fun getItemCount(): Int {
        return items.size
    }
    //override fun getItemCount() : return items.size()

}