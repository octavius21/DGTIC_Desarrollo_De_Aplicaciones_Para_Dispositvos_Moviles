package com.luocz.primerproyecto.Ejercicio1

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.textfield.TextInputEditText
import com.luocz.primerproyecto.R
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val btnGo = findViewById<Button>(R.id.btnGo)
        val tietName = findViewById<TextInputEditText>(R.id.tietName)
        val tietLastName = findViewById<TextInputEditText>(R.id.tietLastName)
        val tietBirth = findViewById<TextInputEditText>(R.id.tietBirth)
        val tietAge = findViewById<TextInputEditText>(R.id.tietAge)
        btnGo.setOnClickListener {
            val validateuser = ValidateUser(tietName.text.toString(),
                tietLastName.text.toString(),
                tietBirth.text.toString(),
                tietAge.text.toString())
            if (!validateuser.validate()) {
                Toast.makeText(this, "Empty Fild Found", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetailActivity::class.java).apply {

                    val user = User(
                        tietName.text.toString(),
                        tietLastName.text.toString(),
                        tietBirth.text.toString(),
                        tietAge.text.toString().toInt()
                    )
                    putExtra("KEY_USER", user)
                }
                startActivity(intent)
            }

        }
    }
}