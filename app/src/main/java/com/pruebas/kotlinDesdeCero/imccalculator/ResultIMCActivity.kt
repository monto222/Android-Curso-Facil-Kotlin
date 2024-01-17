package com.pruebas.kotlinDesdeCero.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.Pruebas.tutorial.R
import com.pruebas.kotlinDesdeCero.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvIMC: TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {//Bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 -> {//Peso Normal
                tvResult.text = getString(R.string.title_peso_normal)
                tvDescription.text = getString(R.string.description_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            }

            in 25.00..29.99 -> {//Sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso)
                tvDescription.text = getString(R.string.description_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
            }

            in 30.00..99.00 -> {//Obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvDescription.text = getString(R.string.description_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }

            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)

            }
        }
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnReCalculate)
    }

}