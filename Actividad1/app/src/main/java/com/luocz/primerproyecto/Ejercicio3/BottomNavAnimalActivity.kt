package com.luocz.primerproyecto.Ejercicio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.luocz.primerproyecto.R

class BottomNavAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_animal)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        val menu = findViewById<BottomNavigationView>(R.id.bttmNVMenu)
        loadFragment(ListAnimalFragment())
        menu.selectedItemId = R.id.bthome
        fabAdd.visibility = View.VISIBLE
        menu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bthome -> {
                    loadFragment(ListAnimalFragment())
                    fabAdd.visibility = View.VISIBLE
                    return@setOnItemSelectedListener true
                }
                R.id.btanimal -> {
                    loadFragment(AddAnimalFragment())
                    fabAdd.visibility = View.INVISIBLE
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener true
            }
        }
        fabAdd.setOnClickListener {
            loadFragment(AddAnimalFragment())
            menu.selectedItemId = R.id.btanimal
            fabAdd.visibility = View.INVISIBLE
            return@setOnClickListener
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainerAnimal, fragment)
            .commit()
    }
}