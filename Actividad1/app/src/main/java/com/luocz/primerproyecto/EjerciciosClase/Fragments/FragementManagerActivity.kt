package com.luocz.primerproyecto.EjerciciosClase.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luocz.primerproyecto.R

class FragementManagerActivity : AppCompatActivity() {
    val name = "Activity-Luis"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragement_manager)

        //val fragment= supportFragmentManager.findFragmentById(R.id.) as FirstFragment

        //fragment.name

        /*supportFragmentManager.beginTransaction()
            .add(R.id.container,FirstFragment(),"FirtsFragment")
            .commit()*/
        supportFragmentManager.beginTransaction()
            .add(R.id.container, FirstFragment.newInstance(name), "FirstFragment")
            .commit()

    }
}