package com.luocz.primerproyecto.EjerciciosClase.Almacenamiento

import android.content.Context
import android.content.SharedPreferences
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.luocz.primerproyecto.R

class PrefsActivity : AppCompatActivity() {
    private lateinit var tvprefs: TextView
    private lateinit var etprefs: EditText
    private lateinit var btsave: Button
    private lateinit var btdelete: Button
    private lateinit var prefs: SharedPreferences
    private val PREFS_NAME = "com.luocz.sharedpreferences"
    private val SHARE_NAME = "shared_name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs)
//        prefs= getPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        tvprefs = findViewById(R.id.tvpref)
        etprefs = findViewById(R.id.etpref)
        btsave = findViewById(R.id.btnSave)
        btdelete = findViewById(R.id.btnDelete)
        btsave.setOnClickListener {
            prefs.edit().putString(SHARE_NAME, etprefs.text.toString()).apply()
            configView()

        }
        btdelete.setOnClickListener {
            prefs.edit().remove(SHARE_NAME).apply()
            configView()
        }
        configView()
    }

    private fun showinfo() {
        etprefs.visibility = View.INVISIBLE
        btsave.visibility = View.INVISIBLE
        btdelete.visibility = View.VISIBLE
        tvprefs.visibility = View.VISIBLE
        tvprefs.text = "Hola ${prefs.getString(SHARE_NAME, "")}"

    }

    private fun askInfo() {


        tvprefs.visibility = View.INVISIBLE
        btdelete.visibility = View.INVISIBLE
        etprefs.visibility = View.VISIBLE
        btsave.visibility = View.VISIBLE


    }

    private fun isInfoSaved(): Boolean {
        val name = prefs.getString(SHARE_NAME, "")
        if (name?.isNotEmpty() == true) {
            return true
        } else {
            return false
        }
        //            otra forma
        // return name?.isNotEmpty() == true
    }

    fun configView() {
        if (isInfoSaved()) showinfo() else askInfo()
    }

}