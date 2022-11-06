package com.luocz.primerproyecto.Ejercicio2

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.luocz.primerproyecto.R
import java.lang.Boolean.TRUE

class AdapterAnimal(private val items : ArrayList<Animal>, private val listener: RecyclerItemAnimalListener, private val context: Context): RecyclerView.Adapter<AnimalViewHolder>() {

    //ASIGNA EL ITEM O LA CARD RELIZADA
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_animal,parent,false)
        return AnimalViewHolder(view)
    }
    //RECILCARA CON LOS CARDS
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.name.text = items[position].name.toString()
        holder.size.text = "Size: "+items[position].size.toString()
        holder.age.text = "Age: " + items [position].age.toString()
        holder.type.text = "Type: " + items[position].type.toString()
        if (items[position].domestic){
            holder.domestic.visibility = View.VISIBLE
        }else{
            holder.domestic.visibility = View.INVISIBLE
        }
        holder.favorite.setOnClickListener{
            holder.favorite.visibility= View.INVISIBLE
            holder.notfavorite.visibility= View.VISIBLE
            holder.favorite.isEnabled = false
            holder.notfavorite.isEnabled = true
            Toast.makeText(context,"Eliminado de Favoritos",Toast.LENGTH_SHORT).show()
        }
        holder.notfavorite.setOnClickListener{
            holder.notfavorite.visibility= View.INVISIBLE
            holder.favorite.visibility= View.VISIBLE
            holder.notfavorite.isEnabled = false
            holder.favorite.isEnabled = true
            Toast.makeText(context,"Agregado a Favoritos",Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener{
            listener.onItemSelected(items[position])
        }

    }
    override fun getItemCount(): Int {
        return items.size
    }




}