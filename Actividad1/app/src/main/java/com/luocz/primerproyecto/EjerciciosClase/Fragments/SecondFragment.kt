package com.luocz.primerproyecto.EjerciciosClase.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.luocz.primerproyecto.R


class SecondFragment : Fragment() {
    var namesecond: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            namesecond = it.getString("ARG_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val tv = view.findViewById<TextView>(R.id.tvsecondtext)
        tv.text = "Modificacion2: " + namesecond + " |  tvSecond:" + tv.text.toString()
        return view
    }

    companion object {
        fun newInstance(name: String): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                }

            }
        }
    }

}