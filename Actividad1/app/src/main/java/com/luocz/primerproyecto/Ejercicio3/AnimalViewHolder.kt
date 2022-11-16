package com.luocz.primerproyecto.Ejercicio3

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.R

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView
    val size: TextView
    val age: TextView
    val type: TextView
    val domestic: ImageView
    val favorite: ImageView
    val notfavorite: ImageView
    val image: ImageView
    val edit: Button
    val delete: Button

    init {
        name = view.findViewById(R.id.tvAnimal)
        size = view.findViewById(R.id.tvSizeAnimal)
        age = view.findViewById(R.id.tvAgeAnimal)
        type = view.findViewById(R.id.tvTypeAnimal)
        domestic = view.findViewById(R.id.img_pet)
        favorite = view.findViewById(R.id.img_star_fill)
        notfavorite = view.findViewById(R.id.img_star_borde)
        image = view.findViewById(R.id.img_animal)
        edit = view.findViewById(R.id.btnEditAnimal)
        delete = view.findViewById(R.id.btnDeleteAnimal)
    }
}