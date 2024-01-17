package com.pruebas.kotlinDesdeCero.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.Pruebas.tutorial.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty() //Como no sabemos si va a ser nulo o no, ponemos el orEMpty y la ? de nulabilidad
        tvResult.text ="Hola $name"
    }
}