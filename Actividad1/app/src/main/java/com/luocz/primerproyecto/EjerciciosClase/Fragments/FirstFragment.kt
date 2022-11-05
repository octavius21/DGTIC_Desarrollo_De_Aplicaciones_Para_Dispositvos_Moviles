package com.luocz.primerproyecto.EjerciciosClase.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.luocz.primerproyecto.R


class FirstFragment : Fragment() {

    var namefirst: String? = null

    companion object {
        fun newInstance(name: String): FirstFragment {
            return FirstFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            namefirst = it.getString("ARG_NAME")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as FragementManagerActivity).name

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment-> no se puede traer el tvtext ya que es de la activity
        val tvtext = view.findViewById<TextView>(R.id.tvtext)
        tvtext.text =
            "Modified_TVTEXT: " + tvtext.text.toString() + " NAME_FIRST_FIRSTFRAGMENT: " + namefirst
        /* tvtext.setOnClickListener{
             parentFragmentManager.beginTransaction()
                 .replace(R.id.container,SecondFragment())
                 .addToBackStack("SecondFragment")
                 .commit()
         }*/
        tvtext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    SecondFragment.newInstance(tvtext.text.toString() ?: "Luis")
                )
                .addToBackStack("SecondFragment")
                .commit()
        }
        return view
    }


}