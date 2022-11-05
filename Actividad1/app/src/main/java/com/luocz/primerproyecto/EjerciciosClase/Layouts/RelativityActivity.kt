package com.luocz.primerproyecto.EjerciciosClase.Layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.luocz.primerproyecto.R

class RelativityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relativity)
        val cbCredit = findViewById<CheckBox>(R.id.cb_tdc)
        val btSave = findViewById<Button>(R.id.btnSent)
        val rgSex = findViewById<RadioGroup>(R.id.rgsex)
        rgSex.check(R.id.rbFem)

        //CHECKBOX
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
        //RADIO GROUP
        rgSex.setOnCheckedChangeListener{_,id ->
            val seletedRb = when(id){
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else ->"Opcion no valida"
            }
            Toast.makeText(this,"RadiobutonSelected:$seletedRb",Toast.LENGTH_SHORT).show()
        }
        //Con lambdas
        rgSex.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                val seletedRb = when(checkedId){
                    R.id.rbMas -> "Masculino"
                    R.id.rbFem -> "Femenino"
                    else ->"Opcion no valida"
                }
                Toast.makeText(this@RelativityActivity,"RadiobutonSelected:$seletedRb",Toast.LENGTH_SHORT).show()
            }

        })

    //Spinner
    val spinner = findViewById<Spinner>(R.id.spin)
        val datos = arrayListOf("Elemento 1", "Elemento 4", "Elemento 3", "Elemento 2", "Elemento 5", "Elemento 6")
        //PAra el valor que se ve luego luego
    val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        //para desplegarze los valores un poco mas
   adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = parent?.getItemAtPosition(position)
                val itemSelected2 = datos[position]
                Toast.makeText(this@RelativityActivity,"NPosicion selecionado:$itemSelected",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }
        }



    //BTN
        btSave.setOnClickListener {
            val isCheck=cbCredit.isChecked
            val itemSelectedPos =spinner.selectedItemPosition
            val spinnerItem=datos[itemSelectedPos]

            val seletedRb = when(rgSex.checkedRadioButtonId){
                R.id.rbMas -> "Masculino"
                R.id.rbFem -> "Femenino"
                else ->"Opcion no valida"
            }
            Toast.makeText(this,"isChecked:$isCheck",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"radioChecked:$seletedRb",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"itemselected:$spinnerItem",Toast.LENGTH_SHORT).show()
        }

    }
}