package com.luocz.primerproyecto.EjerciciosClase.Almacenamiento

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception
import kotlin.collections.ArrayList

class SQLHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "user.db"
        private const val TBL_USER = "tlb_user"
        private const val ID = "id"
        private const val NAME = "name"
        private const val DESCRIPTION = "description"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlCreate = "CREATE TABLE $TBL_USER(" +
                "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$NAME TEXT, " +
                "$DESCRIPTION TEXT)"
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlupdate = "DROP TABLE IF EXISTS $TBL_USER"
        db?.execSQL(sqlupdate)
        onCreate(db)
    }

    fun insert(user: UserSQLModel): Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(NAME, user.name)
            put(DESCRIPTION, user.description)
        }
        val result = db.insert(TBL_USER, null, contentValues)
        db.close()
        return result
    }

    fun getAllUser(): ArrayList<UserSQLModel> {
        val userList = arrayListOf<UserSQLModel>()
        val query = "SELECT * FROM $TBL_USER"
        val db = readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(query, null)
        } catch (e: Exception) {
            e.printStackTrace()
            return userList
        }
        var id: Int
        var name: String
        var description: String
        with(cursor) {
            while (moveToNext()) {
                id = getInt(getColumnIndexOrThrow(ID))
                name = getString(getColumnIndexOrThrow(NAME))
                description = getString(getColumnIndexOrThrow(DESCRIPTION))

                val user = UserSQLModel(id, name, description)
                userList.add(user)
            }
        }
        cursor.close()
//        Ot5ra forma
//        id =cursor.getInt(cursor.getColumnIndexOrThrow(ID))
        return userList
    }

    fun updateUser(user: UserSQLModel): Int {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(ID, user.id)
            put(NAME, user.name)
            put(DESCRIPTION, user.description)
        }
        // val result = db.update(TBL_USER,contentValues,"id=${user.id}",null)
//        Otra forma
//        https://developer.android.com/topic/security/risks/sql-injection#mitigations   ->mitigacion de inyeccion
        val result = db.update(TBL_USER, contentValues, "id=?", arrayOf("${user.id}"))
        return result
    }

    fun deleteUser(userId: Int): Int {
        val db = writableDatabase
        return db.delete(TBL_USER, "id=?", arrayOf("$userId"))
    }
}