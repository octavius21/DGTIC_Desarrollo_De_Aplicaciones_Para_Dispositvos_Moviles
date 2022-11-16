package com.luocz.primerproyecto.Ejercicio3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luocz.primerproyecto.R


class ListAnimalFragment : Fragment(), RecyclerItemListener {
    private lateinit var sqlHelper: SQLHelper
    private lateinit var animalAdapter: Adapter

    companion object {
        fun newInstance(): ListAnimalFragment {
            return ListAnimalFragment().apply {
                arguments = Bundle().apply {

                }

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_animal, container, false)
        sqlHelper = SQLHelper(requireContext())
        animalAdapter = Adapter(sqlHelper.getAllAnimals(), this, requireContext())
        val list = view.findViewById<RecyclerView>(R.id.listAnimal)
        list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        list.itemAnimator = DefaultItemAnimator()
        list.adapter = animalAdapter
        return view
    }

    override fun onItemSelected(animal: Animal) {
        loadFragment(DetailAnimalFragment(), animal)
    }

    private fun loadFragment(fragment: Fragment, animal: Animal) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.flContainerAnimal, DetailAnimalFragment.newInstance(animal))
            .addToBackStack("ListAnimalFragment")
            .commit()
    }

}