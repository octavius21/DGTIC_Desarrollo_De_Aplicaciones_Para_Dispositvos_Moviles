package com.luocz.primerproyecto.EjerciciosClase.Tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.luocz.primerproyecto.R

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        val tabs= findViewById<TabLayout>(R.id.tabs)

        tabs.addTab(tabs.newTab().setText("Users"))
        tabs.addTab(tabs.newTab().setText("Cars"))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.iconsend))
        tabs.tabGravity=TabLayout.GRAVITY_FILL
    }
}
