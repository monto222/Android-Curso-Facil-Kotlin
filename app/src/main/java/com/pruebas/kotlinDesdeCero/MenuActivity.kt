package com.pruebas.kotlinDesdeCero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.Pruebas.tutorial.R
import com.pruebas.kotlinDesdeCero.firstapp.FirstAppActivity
import com.pruebas.kotlinDesdeCero.imccalculator.ImcCalculatorActivity
import com.pruebas.kotlinDesdeCero.settings.SettingsActivity
import com.pruebas.kotlinDesdeCero.superheroapp.SuperHeroListActivity
import com.pruebas.kotlinDesdeCero.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTODOApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroAPP() }
        btnSettings.setOnClickListener { navigateToSettingsApp() }
    }

    private fun navigateToSettingsApp() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSuperHeroAPP() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }


}