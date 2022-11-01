package com.luocz.primerproyecto.Ejercicio1

import java.util.*

class ValidateUser (
    val name: String,
    val lastName: String,
    val birth: String,
    val age: String
        )
{
    fun validate():Boolean{
        return validationUser()
    }
    private fun getName():Boolean {
        return name.isNotBlank() && name.isNotEmpty()
    }
    private fun getLastName():Boolean {
        return lastName.isNotBlank() && lastName.isNotEmpty()
    }
    private fun getBirth():Boolean {
        return birth.isNotBlank() && birth.isNotEmpty()
    }
    private fun getAge():Boolean {
        return age.isNotBlank() && age.isNotEmpty()
    }
    private fun validationUser(): Boolean{
        return getName()&&getLastName()&&getBirth()&&getAge()
    }

}