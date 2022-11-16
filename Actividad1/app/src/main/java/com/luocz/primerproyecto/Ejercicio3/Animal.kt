package com.luocz.primerproyecto.Ejercicio3

import java.io.Serializable

data class Animal(
    val id: Long = 0,
    val name: String = "",
    val size: Char = 'M',
    val age: Int = 0,
    val type: String = "",
    val url: String = "",
    val domestic: Boolean = false,
    val favorite: Boolean = false
) : Serializable
