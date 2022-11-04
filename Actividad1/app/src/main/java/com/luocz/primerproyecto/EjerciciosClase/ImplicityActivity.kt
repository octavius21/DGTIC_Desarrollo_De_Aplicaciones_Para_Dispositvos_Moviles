package com.luocz.primerproyecto.EjerciciosClase

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.luocz.primerproyecto.R

class ImplicityActivity : AppCompatActivity() {
    /*Intent Implicito paso de paramtros; se crea esta actividad para enviar datos a otra aplicacion
    * que maneje este tipo de informacion*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicity)

        val buton = findViewById<Button>(R.id.button)
        buton.setOnClickListener {
            val email = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayListOf("octavio.12@hotmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Hola")
                putExtra(Intent.EXTRA_TEXT,"FYI")
            }
            /*startActivity(email)*/
            startActivity(Intent.createChooser(email,"test"))
        }


    }
}