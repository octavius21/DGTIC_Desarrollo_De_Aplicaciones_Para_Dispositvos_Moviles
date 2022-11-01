package com.luocz.primerproyecto.Ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.luocz.primerproyecto.EjerciciosClase.Usuario
import com.luocz.primerproyecto.R
import java.text.SimpleDateFormat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvBirth = findViewById<TextView>(R.id.tvBirth)

        intent.extras?.let {
            if (it.containsKey("KEY_USER")) {
                val user = it.getSerializable("KEY_USER") as User
                tvName.text = user.name
                tvLastName.text = user.lastName
                tvAge.text = user.age.toString()
                tvBirth.text = user.birth
            }
        } ?: showEmptyInfo()
    }

    private fun showEmptyInfo() {
        Toast.makeText(this, "Extras vacios", Toast.LENGTH_SHORT).show()
    }

}