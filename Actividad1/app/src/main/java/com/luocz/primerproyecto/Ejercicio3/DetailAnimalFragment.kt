package com.luocz.primerproyecto.Ejercicio3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.luocz.primerproyecto.R


private const val ARG_ANIMAL = "animal"


class DetailAnimalFragment : Fragment() {
    private var animal: Animal? = null
    private lateinit var sqlHelper: SQLHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animal = it.getSerializable(ARG_ANIMAL) as Animal?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //INICIALIZACION
        val view = inflater.inflate(R.layout.fragment_detail_animal2, container, false)
        val tietNameAnimal = view.findViewById<TextInputEditText>(R.id.tietNameAnimal)
        val tietAgeAnimal = view.findViewById<TextInputEditText>(R.id.tietAgeAnimal)
        val tietTypeAnimal = view.findViewById<TextInputEditText>(R.id.tietTypeAnimal)
        val tietURLAnimal = view.findViewById<TextInputEditText>(R.id.tietURLAnimal)
        val ivAnimal = view.findViewById<ImageView>(R.id.imgDetailAnimal)
        val btnEdit = view.findViewById<Button>(R.id.btnEditAnimal)
        val rgSizeAnimal = view.findViewById<RadioGroup>(R.id.rgSizeAnimalDetail)
        var selectedRb: Char = 'N'
        var itemSelected = true
        val spinnerAnimal = view.findViewById<Spinner>(R.id.spinAnimal)
        //LSITA DE DATOS A USAR DEL SPINNER
        val datos = arrayListOf("SI", "NO")
        // ADAPTADOR PARA EL SPINNER
        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, datos)
        //PARA DESPLEGAR LA PRIMERA OPCION
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        //ASIGNAR EL ADAPTADOR AL SPINNER
        spinnerAnimal.adapter = adaptador
        //TODO: NOSE COMO DESAPARECER EL FLOATING BUTTON DESDE AQUI PARA QUE NO SE VEA
//        val fabAdd = viewfindViewById<FloatingActionButton>(R.id.fabAdd)
//        fabAdd.visibility = View.INVISIBLE
        //SETEARLOS VALORES DEL ANIMAL
        tietNameAnimal.setText(animal?.name.toString())
        tietAgeAnimal.setText(animal?.age.toString())
        tietTypeAnimal.setText(animal?.type.toString())
        tietURLAnimal.setText(animal?.url.toString())
        //SETEARLO
        when (animal?.size) {
            'S' -> rgSizeAnimal.check(R.id.rbsmall)
            'M' -> rgSizeAnimal.check(R.id.rbmedium)
            'B' -> rgSizeAnimal.check(R.id.rbbig)
        }
        //TODO: Si no le pico y lo guardo no agarra el que esta seleccionado y como setee 'N' me pone 'N'

        //TODO:NOSE COMO OBTENER EL SPINNER->LA OPCION EXACTA
        spinnerAnimal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var isdomestic = parent?.getItemAtPosition(position).toString()
                itemSelected = isdomestic.contains("SI")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        rgSizeAnimal.setOnCheckedChangeListener { _, id ->
            selectedRb = when (id) {
                R.id.rbsmall -> 'S'
                R.id.rbmedium -> 'M'
                R.id.rbbig -> 'B'
                else -> 'N'
            }
        }

//        PONER LA IMAGEN
        Glide.with(this)
            .load(animal?.url)
            .centerCrop()
            .fitCenter()
            .into(ivAnimal)

        btnEdit.setOnClickListener {
            val validateAnimal = ValidateAnimal(
                tietNameAnimal.text.toString(),
                tietAgeAnimal.text.toString().toInt(),
                tietTypeAnimal.text.toString(),
                tietURLAnimal.text.toString()
            )
            if (!validateAnimal.validate()) {
                Toast.makeText(this.context, "Empty Field Found", Toast.LENGTH_SHORT).show()
            } else {


                val editanimal = Animal(
                    id = animal!!.id,
                    name = tietNameAnimal.text.toString(),
                    size = selectedRb,
                    age = tietAgeAnimal.text.toString().toInt(),
                    type = tietTypeAnimal.text.toString(),
                    url = tietURLAnimal.text.toString(),
                    domestic = itemSelected,
                )

                Log.e(
                    "editAnimal", animal?.id.toString() + " " +
                            tietNameAnimal.text.toString() + " " +
                            selectedRb + " " +
                            tietAgeAnimal.text + " " +
                            tietTypeAnimal.text.toString() + " " +
                            tietURLAnimal.text.toString() + " " +
                            itemSelected
                )
                sqlHelper = SQLHelper(requireContext())
                sqlHelper.updateAnimal(editanimal)
                loadFragment(ListAnimalFragment())
            }
        }

        return view
    }

    companion object {
        fun newInstance(animal: Animal) =
            DetailAnimalFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ANIMAL, animal)
                }
            }
    }

    private fun loadFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.flContainerAnimal, fragment)
            .commit()
    }
}