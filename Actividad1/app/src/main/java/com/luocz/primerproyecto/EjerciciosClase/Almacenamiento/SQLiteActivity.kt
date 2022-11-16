package com.luocz.primerproyecto.EjerciciosClase.Almacenamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.luocz.primerproyecto.Ejercicio1.User
import com.luocz.primerproyecto.EjerciciosClase.RecycleView.UserItem
import com.luocz.primerproyecto.R

class SQLiteActivity : AppCompatActivity(), RecyclerItemUserListener {
    private lateinit var sqlHelper: SQLHelper
    private lateinit var userAdapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        val etName = findViewById<EditText>(R.id.etName)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val btnAdd = findViewById<Button>(R.id.btnSaveUser)
        val btnShow = findViewById<Button>(R.id.btnShowUser)
        val btnUpdate = findViewById<Button>(R.id.btnUpdateUser)
        val btnDelete = findViewById<Button>(R.id.btnDeleteUser)
        val list = findViewById<RecyclerView>(R.id.list)
        sqlHelper = SQLHelper(this)
        userAdapter = Adapter(sqlHelper.getAllUser(), this)
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list.itemAnimator = DefaultItemAnimator()
        list.adapter = userAdapter




        btnAdd.setOnClickListener {
            if (etName.text.toString().isNotEmpty() and etDescription.text.toString()
                    .isNotEmpty()
            ) {
                val user = UserSQLModel(
                    name = etName.text.toString(),
                    description = etDescription.text.toString()
                )
                val result = sqlHelper.insert(user)
                if (result > -1) {
                    userAdapter.updateItems(sqlHelper.getAllUser())
                    Toast.makeText(this, "Se ingresaron los datos", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No se ingresaron los datos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Ingrese datos", Toast.LENGTH_SHORT).show()
            }
        }
        btnShow.setOnClickListener {
//            val list =sqlHelper.getAllUser()
//          Para poder visualizarlo de nuevo(manera no practica)
//            val userAdapter = Adapter(sqlHelper.getAllUser(), this)
//            list.adapter = userAdapter
//          Una forma practica es asi
            val list =sqlHelper.getAllUser()
            userAdapter.updateItems(list)
            Log.e("Lista:", list.toString())
        }
        btnUpdate.setOnClickListener {
            val userUpdated =
                UserSQLModel(id = 2, name = "Jose Martinez", description = "Description")
            val result = sqlHelper.updateUser(userUpdated)
            if (result > -1) {
                Toast.makeText(this, "Actualizo datos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No Actualizo datos", Toast.LENGTH_SHORT).show()
            }
        }
        btnDelete.setOnClickListener {
            val result = sqlHelper.deleteUser(3)
            if (result > 0) {
                Toast.makeText(this, "Eliminacion de datos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No Elimino datos", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onItemSelected(userSQLModel: UserSQLModel) {
        Toast.makeText(this, "USer:${userSQLModel.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onResume(){
        super.onResume()
        userAdapter.updateItems(sqlHelper.getAllUser())
    }

}