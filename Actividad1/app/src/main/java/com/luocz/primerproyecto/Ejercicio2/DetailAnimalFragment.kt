package com.luocz.primerproyecto.Ejercicio2

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.luocz.primerproyecto.R

private const val ARG_ANIMAL = "animal"

class DetailAnimalFragment : Fragment() {

    private var animal: Animal? = null
    //Clase estatica y se inicializa primero
    companion object {
        fun newInstance(animal: Animal):DetailAnimalFragment {
            return DetailAnimalFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_ANIMAL, animal)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animal = it.getSerializable(ARG_ANIMAL) as Animal
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail_animal, container, false)
        val tvNameAnimal =  view.findViewById<TextView>(R.id.tvNameAnimal)
        val cbEnfermedadAnimal = view.findViewById<CheckBox>(R.id.cbEnfermedadAnimal)
        val imgAnimal =view.findViewById<ImageView>(R.id.img_pet)
        val btnSaveAnimal = view.findViewById<Button>(R.id.btnSaveAnimal)
        val rgGender = view.findViewById<RadioGroup>(R.id.rgGender)
        val spinner = view.findViewById<Spinner>(R.id.spinAnimal)
        val datos = arrayListOf("Cita", "Consulta", "Emergencia", "Resguardo", "Funerario")
        tvNameAnimal.text = animal?.name ?: "Nose"
        tvNameAnimal.isEnabled = false


       /* when(animal?.type.toString()){
            "Canino" ->{
                imgAnimal.setImageResource(resources.getIdentifier("Perro",null,null))
            }
            "Reptil"->{
                imgAnimal.setImageResource(resources.getIdentifier("Reptil",null,null))
            }
            "Ave"->{
                imgAnimal.setImageResource(resources.getIdentifier("Ave",null,null))
            }
            "Felino"->{
                imgAnimal.setImageResource(resources.getIdentifier("Felino",null,null))
            }
            "Cetaceo"->{
                imgAnimal.setImageResource(resources.getIdentifier("Cetaceo",null,null))
            }
        }*/


        rgGender.setOnCheckedChangeListener{_,id ->
            val selectedRb = when(id){
                R.id.rbMale -> "Macho"
                R.id.rbFemale -> "Hembra"
                else ->"Opcion no valida"
            }
//            Toast.makeText(requireContext(),"RadiobutonSelected:$selectedRb ",Toast.LENGTH_SHORT).show()
        }


        val adaptador = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, datos)
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = parent?.getItemAtPosition(position)
//                Toast.makeText(requireContext(),"Posicion selecionada:$itemSelected",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            //NIDIEA
            }
        }

        //BTN
        btnSaveAnimal.setOnClickListener {
            val isCheck=cbEnfermedadAnimal.isChecked
            val itemSelectedPos =spinner.selectedItemPosition
            val spinnerItem=datos[itemSelectedPos]

            val selectedRb = when(rgGender.checkedRadioButtonId){
                R.id.rbMas -> "Macho"
                R.id.rbFem -> "Hembra"
                else ->"Opcion no valida"
            }
            /*Toast.makeText(activity,"isChecked:$isCheck",Toast.LENGTH_SHORT).show()
            Toast.makeText(activity,"radioChecked:$selectedRb",Toast.LENGTH_SHORT).show()
            Toast.makeText(activity,"itemselected:$spinnerItem",Toast.LENGTH_SHORT).show()*/
            Toast.makeText(activity,"¡Guardado!",Toast.LENGTH_SHORT).show()
        }

        return view
    }


}