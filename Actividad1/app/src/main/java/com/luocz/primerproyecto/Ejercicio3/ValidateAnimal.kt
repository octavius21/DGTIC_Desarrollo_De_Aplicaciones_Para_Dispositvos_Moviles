package com.luocz.primerproyecto.Ejercicio3

class ValidateAnimal(
    val name: String,
    val age: Int,
    val type: String,
    val url: String
) {
    fun validate(): Boolean {
        return validationAnimal()
    }

    private fun getName(): Boolean {
        return name.isNotBlank() && name.isNotEmpty()
    }

    private fun getLastName(): Boolean {
        return age.toString().isNotBlank() && age.toString().isNotEmpty()
    }

    private fun getBirth(): Boolean {
        return type.isNotBlank() && type.isNotEmpty()
    }

    private fun getAge(): Boolean {
        return url.isNotBlank() && url.isNotEmpty()
    }

    private fun validationAnimal(): Boolean {
        return getName() && getLastName() && getBirth() && getAge()
    }

}
