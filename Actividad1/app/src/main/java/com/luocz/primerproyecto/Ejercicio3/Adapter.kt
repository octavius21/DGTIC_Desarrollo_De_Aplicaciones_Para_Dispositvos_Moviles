package com.luocz.primerproyecto.Ejercicio3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luocz.primerproyecto.R


class Adapter(
    private val items: ArrayList<Animal>,
    private val listener: RecyclerItemListener,
    private val context: Context
) : RecyclerView.Adapter<AnimalViewHolder>() {
    private lateinit var sqlHelper: SQLHelper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_animal2, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        sqlHelper = SQLHelper(context)
        holder.name.text = items[position].name
        holder.size.text = "Size: " + items[position].size.toString()
        holder.age.text = "Age: " + items[position].age.toString()
        holder.type.text = "Type: " + items[position].type
        if (sqlHelper.searchAnimalDomestic(items[position].id)) {
            holder.domestic.visibility = View.VISIBLE
        } else {
            holder.domestic.visibility = View.INVISIBLE
        }
        holder.favorite.setOnClickListener {
            val result = sqlHelper.deleteFavorite(sqlHelper.searchAnimal(items[position].id))
            holder.favorite.visibility = View.INVISIBLE
            holder.notfavorite.visibility = View.VISIBLE
            holder.favorite.isEnabled = false
            holder.notfavorite.isEnabled = true

            Toast.makeText(context, "Eliminado de Favoritos", Toast.LENGTH_SHORT).show()
        }
        holder.notfavorite.setOnClickListener {
            val result = sqlHelper.addFavorite(sqlHelper.searchAnimal(items[position].id))
            holder.notfavorite.visibility = View.INVISIBLE
            holder.favorite.visibility = View.VISIBLE
            holder.notfavorite.isEnabled = false
            holder.favorite.isEnabled = true
            Toast.makeText(context, "Agregado a Favoritos", Toast.LENGTH_SHORT).show()
        }
        /* holder.edit.setOnClickListener {
             //TODO: NOSE COMO ENVIAR A LA PANTALLA DE EDITAR
             supportFragmentManager.beginTransaction()
                 .replace(R.id.flContainerAnimal, DetailAnimalFragment)
                 .commit()
         }*/
        holder.delete.setOnClickListener {
            val result = sqlHelper.deleteAnimal(items[position].id)
            if (result > 0) {
                Toast.makeText(context, "Se elimino el registro ", Toast.LENGTH_SHORT).show()
                updateItems(sqlHelper.getAllAnimals())
            } else {
                Toast.makeText(context, "No se elimino el registro ", Toast.LENGTH_SHORT).show()
            }
        }
        Glide.with(context)
            .load(items[position].url)
            .centerCrop()
            .fitCenter()
            .into(holder.image)

        holder.itemView.setOnClickListener {
            listener.onItemSelected(items[position])
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: ArrayList<Animal>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}

