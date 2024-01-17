package com.pruebas.kotlinDesdeCero.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.Pruebas.tutorial.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import android.util.Log
import android.widget.Button

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentHeight: Int = 120
    private var currentAge: Int = 30


    private lateinit var viewHombre: CardView
    private lateinit var viewMujer: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewHombre = findViewById(R.id.viewHombre)
        viewMujer = findViewById(R.id.viewMujer)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewHombre.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewMujer.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->//sirve para quitar el .0 que creaba sin querer

            val dFormat = DecimalFormat("#.##")
            currentHeight = dFormat.format(value).toInt()
            tvHeight.text = "$currentHeight cm"

        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY,result)
        startActivity(intent)
    }


    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() /100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setAge() {
        tvAge.text = "$currentAge"
    }

    private fun setWeight() {
        tvWeight.text = "$currentWeight"
    }

    private fun setGenderColor() {
        viewHombre.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewMujer.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}