package com.luocz.primerproyecto.Ejercicio3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.luocz.primerproyecto.Ejercicio1.DetailActivity
import com.luocz.primerproyecto.Ejercicio1.User
import com.luocz.primerproyecto.R


class AddAnimalFragment : Fragment() {

    private lateinit var sqlHelper: SQLHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //DECLARACIONES
        val view = inflater.inflate(R.layout.fragment_add_animal, container, false)
        val tietNameAnimal = view.findViewById<TextInputEditText>(R.id.tietNameAnimal)
        val tietAgeAnimal = view.findViewById<TextInputEditText>(R.id.tietAgeAnimal)
        val tietTypeAnimal = view.findViewById<TextInputEditText>(R.id.tietTypeAnimal)
        val tietURLAnimal = view.findViewById<TextInputEditText>(R.id.tietURLAnimal)
        val btnGo = view.findViewById<Button>(R.id.btnGo)
        val rgSizeAnimal = view.findViewById<RadioGroup>(R.id.rgSizeAnimal)
        var selectedRb: Char = 'S'
        var itemSelected: Boolean = false
        val spinnerAnimal = view.findViewById<Spinner>(R.id.spinDomesticAnimal)
        //LSITA DE DATOS A USAR DEL SPINNER
        val datos = arrayListOf("SI", "NO")
        // ADAPTADOR PARA EL SPINNER
        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, datos)
        //PARA DESPLEGAR LA PRIMERA OPCION
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        //ASIGNAR EL ADAPTADOR AL SPINNER
        spinnerAnimal.adapter = adaptador
        //SETEAR EL RADIOGROUP CON UNA OPCION
        rgSizeAnimal.check(R.id.rbsmall)
//      Obtener si es Mascota
        spinnerAnimal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val isdomestic = parent?.getItemAtPosition(position).toString()
                itemSelected = isdomestic.contains("SI")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
//         Obtener el tamaño
        rgSizeAnimal.setOnCheckedChangeListener { _, id ->
            selectedRb = when (id) {
                R.id.rbsmall -> 'S'
                R.id.rbmedium -> 'M'
                R.id.rbbig -> 'B'
                else -> 'N'
            }
        }

        btnGo.setOnClickListener {
            val validateAnimal = ValidateAnimal(
                tietNameAnimal.text.toString(),
                tietAgeAnimal.text.toString().toInt(),
                tietTypeAnimal.text.toString(),
                tietURLAnimal.text.toString()
            )
            if (!validateAnimal.validate()) {
                Toast.makeText(this.context, "Empty Field Found", Toast.LENGTH_SHORT).show()
            } else {

                val addanimal = Animal(
                    name = tietNameAnimal.text.toString(),
                    size = selectedRb,
                    age = tietAgeAnimal.text.toString().toInt(),
                    type = tietTypeAnimal.text.toString(),
                    url = tietURLAnimal.text.toString(),
                    domestic = itemSelected,
                    favorite = false
                )
                Toast.makeText(
                    requireContext(), tietNameAnimal.text.toString() + " " +
                            selectedRb + " " +
                            tietAgeAnimal.text + "" +
                            tietTypeAnimal.text.toString() + " " +
                            tietURLAnimal.text.toString() + " " +
                            itemSelected + " " +
                            false, Toast.LENGTH_SHORT
                ).show()
                Log.e(
                    "addAnimal", tietNameAnimal.text.toString() + " " +
                            selectedRb + " " +
                            tietAgeAnimal.text + " " +
                            tietTypeAnimal.text.toString() + " " +
                            tietURLAnimal.text.toString() + " " +
                            itemSelected + " " +
                            false
                )
                sqlHelper = SQLHelper(requireContext())
                sqlHelper.insertAnimal(addanimal)

                clearFields(tietNameAnimal, tietAgeAnimal, tietTypeAnimal, tietURLAnimal)
                loadFragment(ListAnimalFragment())
            }
        }

        return view
    }


    private fun clearFields(
        tietNameAnimal: TextInputEditText, tietAgeAnimal: TextInputEditText,
        tietTypeAnimal: TextInputEditText, tietURLAnimal: TextInputEditText
    ) {
        tietNameAnimal.setText("")
        tietAgeAnimal.setText("")
        tietTypeAnimal.setText("")
        tietURLAnimal.setText("")
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.flContainerAnimal, fragment)
            .commit()
    }

    companion object {

        fun newInstance() =
            AddAnimalFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}