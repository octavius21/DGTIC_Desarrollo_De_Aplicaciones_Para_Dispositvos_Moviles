package com.luocz.primerproyecto.EjerciciosClase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.luocz.primerproyecto.R

class ExplicitActivity : AppCompatActivity() {
    /*Intent Explicito paso de paramtros; se crea esta actividad para enviar datos a otra actividad*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)
        val btnEnviar = findViewById<Button>(R.id.btnSent)
        val etName = findViewById<EditText>(R.id.etName)

        btnEnviar.setOnClickListener {
            val text = etName.text.toString()
            if (!text.isNotEmpty()) {
                Toast.makeText(this, "Nombre vacio", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this, ExplicitDetailActivity::class.java).apply {
                    putExtra("KEY_NAME", "Luis")
                    putExtra("KEY_LASTNAME", "Gómez")
                    putExtra("KEY_AGE", 26)
                    val user = Usuario("Octavio", "De la Cruz", 16)
                    putExtra("KEY_USER", user)
                    putExtra("KEY_ET_NAME",text)
                }
                startActivity(intent)
            }
        }


    }
}