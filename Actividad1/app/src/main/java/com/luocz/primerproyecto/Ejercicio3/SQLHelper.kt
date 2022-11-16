package com.luocz.primerproyecto.Ejercicio3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.luocz.primerproyecto.EjerciciosClase.Almacenamiento.UserSQLModel
import java.lang.Exception

class SQLHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "animal.db"
        private const val TBL_ANIMAL = "tlb_animal"
        private const val ID = "id"
        private const val NAME = "name"
        private const val SIZE = "size"
        private const val AGE = "age"
        private const val TYPE = "type"
        private const val URL = "url"
        private const val DOMESTIC = "domestic"
        private const val FAVORITE = "favorite"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreate = "CREATE TABLE $TBL_ANIMAL(" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NAME TEXT, " +
                "$SIZE TEXT, " +
                "$AGE INTEGER, " +
                "$TYPE TEXT, " +
                "$URL TEXT, " +
                "$DOMESTIC TEXT, " +
                "$FAVORITE TEXT )"
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlupdate = "DROP TABLE IF EXISTS $TBL_ANIMAL"
        db?.execSQL(sqlupdate)
        onCreate(db)
    }

    fun insertAnimal(animal: Animal): Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(NAME, animal.name)
            put(SIZE, animal.size.toString())
            put(AGE, animal.age)
            put(TYPE, animal.type)
            put(URL, animal.url)
            put(DOMESTIC, animal.domestic.toString())
            put(FAVORITE, animal.favorite.toString())
        }
        val result = db.insert(TBL_ANIMAL, null, contentValues)
        db.close()
        return result
    }

    fun getAllAnimals(): ArrayList<Animal> {
        val animalList = arrayListOf<Animal>()
        val query = "SELECT * FROM $TBL_ANIMAL"
        val db = readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return animalList
        }
        var id: Long
        var name: String
        var size: String
        var age: Int
        var type: String
        var url: String
        var domestic: Boolean
        var favorite: Boolean
        with(cursor) {
            while (moveToNext()) {
                id = getLong(getColumnIndexOrThrow(ID))
                name = getString(getColumnIndexOrThrow(NAME))
                size = getString(getColumnIndexOrThrow(SIZE))
                age = getInt(getColumnIndexOrThrow(AGE))
                type = getString(getColumnIndexOrThrow(TYPE))
                url = getString(getColumnIndexOrThrow(URL))
                domestic = getString(getColumnIndexOrThrow(DOMESTIC)).toBoolean()
                favorite = getString(getColumnIndexOrThrow(FAVORITE)).toBoolean()

                val animal = Animal(id, name, size[0], age, type, url, domestic, favorite)
                animalList.add(animal)
            }
        }
        cursor.close()
        return animalList
    }

    fun updateAnimal(animal: Animal): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(NAME, animal.name)
            put(SIZE, animal.size.toString())
            put(AGE, animal.age)
            put(TYPE, animal.type)
            put(URL, animal.url)
            put(DOMESTIC, animal.domestic.toString())
        }
        val result = db.update(TBL_ANIMAL, contentValues, "id = ?", arrayOf("${animal.id}"))
        return result
    }

    fun addFavorite(animal: Animal): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(FAVORITE, true.toString())
        }
        val result = db.update(TBL_ANIMAL, contentValues, "id = ?", arrayOf("${animal.id}"))
        return result
    }

    fun deleteFavorite(animal: Animal): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(FAVORITE, false.toString())
        }
        val result = db.update(TBL_ANIMAL, contentValues, "id = ?", arrayOf("${animal.id}"))
        return result
    }

    fun searchAnimal(id: Long): Animal {
        var animal = Animal()
        val query = "SELECT * FROM $TBL_ANIMAL WHERE $ID = $id"
        val db = readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return animal
        }
        var id: Long
        var name: String
        var size: String
        var age: Int
        var type: String
        var url: String
        var domestic: Boolean
        var favorite: Boolean
        with(cursor) {
            while (moveToNext()) {
                id = getLong(getColumnIndexOrThrow(ID))
                name = getString(getColumnIndexOrThrow(NAME))
                size = getString(getColumnIndexOrThrow(SIZE))
                age = getInt(getColumnIndexOrThrow(AGE))
                type = getString(getColumnIndexOrThrow(TYPE))
                url = getString(getColumnIndexOrThrow(URL))
                domestic = getString(getColumnIndexOrThrow(DOMESTIC)).toBoolean()
                favorite = getString(getColumnIndexOrThrow(FAVORITE)).toBoolean()

                animal = Animal(id, name, size[0], age, type, url, domestic, favorite)
            }
        }
        cursor.close()
        return animal
    }

    fun searchAnimalDomestic(id: Long): Boolean {
        var result = false
        val query = "SELECT $DOMESTIC FROM $TBL_ANIMAL WHERE $ID = $id"
        val db = readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return result
        }
        var domestic: Boolean
        with(cursor) {
            while (moveToNext()) {
//                id = getLong(getColumnIndexOrThrow(ID))
                domestic = getString(getColumnIndexOrThrow(DOMESTIC)).toBoolean()
                result = domestic
            }
        }
        cursor.close()
        return result
    }

    fun deleteAnimal(animalId: Long): Int {
        val db = writableDatabase
        return db.delete(TBL_ANIMAL, "id = ?", arrayOf("$animalId"))
    }
}