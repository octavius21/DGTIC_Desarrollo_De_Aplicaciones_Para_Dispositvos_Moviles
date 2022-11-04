package com.luocz.primerproyecto.Ejercicio1

import java.io.Serializable
import java.util.*

data class User(
    val name: String,
    val lastName: String,
    val birth: String,
    val age: Number
) : Serializable