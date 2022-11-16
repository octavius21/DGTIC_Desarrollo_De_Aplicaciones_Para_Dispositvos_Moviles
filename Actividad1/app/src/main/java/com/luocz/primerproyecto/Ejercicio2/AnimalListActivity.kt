package com.luocz.primerproyecto.Ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.luocz.primerproyecto.Ejercicio2.RecyclerItemAnimalListener
import com.luocz.primerproyecto.EjerciciosClase.Fragments.FirstFragment
import com.luocz.primerproyecto.R

class AnimalListActivity : AppCompatActivity(), RecyclerItemAnimalListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list =findViewById<RecyclerView>(R.id.listAnimal)
        val animalAdapter = AdapterAnimal(getData(),this,this)

       // list.layoutManager = GridLayoutManager(this,2)
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list.itemAnimator= DefaultItemAnimator()

        list.adapter =animalAdapter
    }
    private fun getData():ArrayList<Animal>{
        val data = arrayListOf<Animal>()
        data.add(Animal("Luis", 'M',10,"Felino",true,false))
        data.add(Animal("Octavio", 'G',11,"Felino",true,false))
        data.add(Animal("Manuela", 'M',12,"Canino",false,true))
        data.add(Animal("Angel", 'G',13,"Canino",true,false))
        data.add(Animal("Pizzarro", 'M',14,"Reptil",false,false))
        data.add(Animal("kent", 'G',15,"Reptil",true,false))
        data.add(Animal("Ben", 'C',16,"Ave",false,false))
        data.add(Animal("Mack", 'G',17,"Ave",true,false))
        data.add(Animal("Vio", 'G',18,"Cetaceo",false,false))
        return data
    }
    override fun onItemSelected(animal: Animal) {
        supportFragmentManager.beginTransaction()
            .add(R.id.containerAnimal, DetailAnimalFragment.newInstance(animal), "DetailAnimalFragment")
//                No me funciona :(
//            .replace(R.id.containerAnimal, DetailAnimalFragment.newInstance(animal), "DetailAnimalFragment")
            .addToBackStack("DetailAnimalFragment")
            .commit()



//        Toast.makeText(this,"USer:${animal.name}", Toast.LENGTH_SHORT).show()
    }
}