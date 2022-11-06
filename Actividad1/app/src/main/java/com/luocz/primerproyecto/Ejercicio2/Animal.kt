package com.luocz.primerproyecto.Ejercicio2

import java.io.Serializable

data class Animal(
    var name: String,
    val size: Char,
    val age: Int,
    val type: String,
    var domestic: Boolean,
    val favorite:Boolean
): Serializable
