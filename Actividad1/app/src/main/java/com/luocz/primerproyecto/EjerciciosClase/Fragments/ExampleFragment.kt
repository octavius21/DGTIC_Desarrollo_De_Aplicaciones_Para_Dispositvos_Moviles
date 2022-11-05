package com.luocz.primerproyecto.EjerciciosClase.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luocz.primerproyecto.R


class ExampleFragment : Fragment() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("FragmentExample","Estoy en onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("FragmentExample","Estoy en onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("FragmentExample","Estoy en onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("FragmentExample","Estoy en onPuase")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("FragmentExample","Estoy en onDestroy")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("FragmentExample","Estoy en onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("FragmentExample","Estoy en onDetach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("FragmentExample","Estoy en onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false)
    }



}