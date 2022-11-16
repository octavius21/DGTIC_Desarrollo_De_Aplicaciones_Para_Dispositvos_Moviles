package com.luocz.primerproyecto.EjerciciosClase.File

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.luocz.primerproyecto.R

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
        val btSave = findViewById<Button>(R.id.btSave)
        val etInfo = findViewById<EditText>(R.id.etfile)
        val image = findViewById<ImageView>(R.id.image)

        Glide.with(this)
            .load("https://phantom-marca.unidadeditorial.es/77132f54b2f2929f7d49c7d4694aa3f1/resize/1320/f/jpg/assets/multimedia/imagenes/2022/11/11/16681770918151.jpg")
//                Cortar y centrar la imagen
            .centerCrop()
//                Cortar imagen y la justara en ese espacio
//            .fitCenter()
            .into(image)


        val fileName = "test.txt"
        val body ="Write"
        resources.openRawResource(R.raw.ejemplo_raw).use {stream ->
            val text =stream.bufferedReader().use{
                it.readText()
            }
            Toast.makeText(this,"Guardando: ${text}",Toast.LENGTH_LONG).show()
        }

        btSave.setOnClickListener {
            openFileOutput(fileName, Context.MODE_PRIVATE).use{ output->
//                output.write(body.toByteArray())
                output.write(etInfo.text.toString().toByteArray())
            }
            openFileInput(fileName).use{stream->
                val text = stream.bufferedReader().use(){
                    it.readText()
                }
                Toast.makeText(this,"Guardando: ${text}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}