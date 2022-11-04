package com.luocz.primerproyecto.EjerciciosClase

import java.io.Serializable

data class Usuario(
    val name: String,
    val lastname: String,
    val age: Int
) : Serializable


