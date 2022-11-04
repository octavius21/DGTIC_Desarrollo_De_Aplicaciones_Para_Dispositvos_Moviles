package com.luocz.primerproyecto.EjerciciosClase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.luocz.primerproyecto.R

class ImplicityActivity2 : AppCompatActivity() {
/*Se creo para ver que si no se declara en el manifest y se hace llamar la activity, da error ya
que no esta declarada en el Manifiesto*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicity_2)


    }
}