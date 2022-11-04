package com.luocz.primerproyecto.EjerciciosClase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.luocz.primerproyecto.R

class ExplicitDetailActivity : AppCompatActivity() {
    /*Esta actividad se hizo para poder recuperar los Put Extra*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_detail)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)

        intent.extras?.let {
            if (it.containsKey("KEY_NAME")) {
                val name = it.getString("KEY_NAME")
                tvName.text = name
            }
            if (it.containsKey("KEY_LASTNAME")) {
                val lastname = it.getString("KEY_LASTNAME")
                tvLastName.text = lastname
            }
            if (it.containsKey("KEY_AGE")) {
                val age = it.getInt("KEY_AGE")
                tvAge.text = age.toString()
                tvAge.text = "$age"
            }
            if (it.containsKey("KEY_USER")) {
                val user = it.getSerializable("KEY_USER") as Usuario
                /*MIO*/
                val userm: Usuario = it.getSerializable("KEY_USER") as Usuario
                tvName.text = userm.name
                tvLastName.text = user.name
                tvAge.text = user.age.toString()
            }
            if (it.containsKey("KEY_ET_NAME")){
                val etNameString =it.getString("KEY_ET_NAME")
                Toast.makeText(this,etNameString,Toast.LENGTH_SHORT).show()
            }
        } ?: showEmptyInfo()
    }

    private fun showEmptyInfo() {
        Toast.makeText(this, "Extras vacio", Toast.LENGTH_SHORT).show()
    }
}