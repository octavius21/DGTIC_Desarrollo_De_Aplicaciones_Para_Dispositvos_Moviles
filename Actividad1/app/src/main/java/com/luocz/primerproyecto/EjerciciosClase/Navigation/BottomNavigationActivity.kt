package com.luocz.primerproyecto.EjerciciosClase.Navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luocz.primerproyecto.R

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        
        val menu = findViewById<BottomNavigationView>(R.id.btnNVmenu)
//        Caragar el primer fragment
            loadFrgament(HomeFragment())
//        Para seleccionar por default
        menu.selectedItemId=R.id.bthome
        //flecita para atras
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        menu.setOnItemSelectedListener{
            when(it.itemId){
                R.id.btcar->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.flContainer, CarFragment())
                        .commit()
                    return@setOnItemSelectedListener true
                    
                }
                R.id.bthome->{
                    loadFrgament(HomeFragment())
                    return@setOnItemSelectedListener true
                }
               /* R.id.btuser->{
                    
                }
                R.id.btnSent->{
                    
                }*/
                else->return@setOnItemSelectedListener false
            }
        }
    }
    private fun loadFrgament(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer,fragment)
            .commit()
    }
}