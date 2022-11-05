package com.luocz.primerproyecto.EjerciciosClase.Layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import com.luocz.primerproyecto.R

class RelativityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relativity)
        val cbCredit = findViewById<CheckBox>(R.id.cb_tdc)
        val btSave = findViewById<Button>(R.id.btnSent)
        val rgSex = findViewById<RadioGroup>(R.id.rgsex)
        rgSex.check(R.id.rbFem)

        cbCredit.isChecked = false
        cbCredit.setOnCheckedChangeListener{ compoundButton, isChecked ->
            if (isChecked ==false){
                btSave.isEnabled=false
            }else{
                btSave.isEnabled=true
            }
            btSave.isEnabled = isChecked != false
            Toast.makeText(this,"isChecked+$isChecked",Toast.LENGTH_SHORT).show()
        }
        rgSex.setOnCheckedChangeListener{_,id ->
            val seletedRb = when(id){
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else ->"Opcion no valida"
            }
            Toast.makeText(this,"RadiobutonSelected:$seletedRb",Toast.LENGTH_SHORT).show()
        }


        btSave.setOnClickListener {
            val isCheck=cbCredit.isChecked

            Toast.makeText(this,"isChecked:$isCheck",Toast.LENGTH_SHORT).show()
        }

    }
}