package com.luocz.primerproyecto.EjerciciosClase.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.*
import com.luocz.primerproyecto.Ejercicio1.User
import com.luocz.primerproyecto.R

class RecyclerViewActivity : AppCompatActivity(), RecyclerItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val list = findViewById<RecyclerView>(R.id.list)
        val userAdapter =Adapter(getData(),this)

        list.layoutManager =GridLayoutManager(this,2)
        //list.layoutManager =LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        //list.layoutManager =LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        //Para poner lineas
        list.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        list.itemAnimator=DefaultItemAnimator()

        list.adapter =userAdapter
    }

    private fun getData():ArrayList<UserItem>{
        val data = arrayListOf<UserItem>()
        data.add(UserItem("Luis", "12343"))
        data.add(UserItem("Octavio", "12243"))
        data.add(UserItem("Manuela", "12043"))
        data.add(UserItem("Angel", "12943"))
        data.add(UserItem("Pizzarro", "12843"))
        data.add(UserItem("kent", "12743"))
        data.add(UserItem("Ben", "12643"))
        data.add(UserItem("Mack", "12543"))
        data.add(UserItem("Vio", "12443"))
        return data
    }

    override fun onItemSelected(user: UserItem) {
        Toast.makeText(this,"USer:${user.name}",Toast.LENGTH_SHORT).show()
    }
}