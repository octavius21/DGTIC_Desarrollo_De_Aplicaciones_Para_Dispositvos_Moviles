package com.luocz.primerproyecto.EjerciciosClase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luocz.primerproyecto.R

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val intent = Intent(this, ImplicityActivity::class.java)
        startActivity(intent)
        Log.i(TAG,"Entre en onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"Entre en onStart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"Entre en onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"Entre en onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"Entre en onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"Entre en onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"Entre en onRestart")
    }
}