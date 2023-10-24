package com.example.kotlinbasics.imcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.kotlinbasics.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private val TAG = ImcCalculatorActivity::class.qualifiedName
    private var selectedGender = "male"
    private var currentWeight: Int = 70
    private var currentAge: Int = 25
    private var currentHeight: Int = 120

    private lateinit var maleView: CardView
    private lateinit var femaleView: CardView
    private lateinit var heightRangeSlider: RangeSlider
    private lateinit var heightTextView: TextView
    private lateinit var addWeightButton: FloatingActionButton
    private lateinit var subtractWightButton: FloatingActionButton
    private lateinit var weightTextView: TextView

    private lateinit var addAgeButton: FloatingActionButton
    private lateinit var subtractAgeButton: FloatingActionButton
    private lateinit var ageTextView: TextView

    private lateinit var calculateButton: Button

    companion object {
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
        maleView = findViewById(R.id.view_male)
        femaleView = findViewById(R.id.view_female)
        heightRangeSlider = findViewById(R.id.range_slider_height)
        heightTextView = findViewById(R.id.text_view_height)
        addWeightButton = findViewById(R.id.button_add_weight)
        subtractWightButton = findViewById(R.id.button_subtract_weight)
        weightTextView = findViewById(R.id.text_view_weight)

        addAgeButton = findViewById(R.id.button_add_age)
        subtractAgeButton = findViewById(R.id.button_subtract_age)
        ageTextView = findViewById(R.id.text_view_age)

        calculateButton = findViewById(R.id.button_calculate)
    }

    private fun initListeners() {
        maleView.setOnClickListener {
            Log.i(TAG, "initListeners: ")
            changeGender("male")
            setGenderColor()
        }
        femaleView.setOnClickListener {
            changeGender("female")
            setGenderColor()
        }
        heightRangeSlider.addOnChangeListener { _, value, _ ->
            val decimalFormat = DecimalFormat("#")
            currentHeight = decimalFormat.format(value).toInt()
            heightTextView.text = "$currentHeight cm"
        }
        addWeightButton.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        subtractWightButton.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        addAgeButton.setOnClickListener {
            currentAge += 1
            setAge()
        }
        subtractAgeButton.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        calculateButton.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun setAge() {
        ageTextView.text = currentAge.toString()
    }

    private fun setWeight() {
        weightTextView.text = currentWeight.toString()
    }

    private fun changeGender(gender: String) {
        if (gender != selectedGender) {
            Log.i(TAG, "changeGender: ")
            selectedGender = if (gender == "male") {
                "male"
            } else {
                "female"
            }
        }
    }

    private fun setGenderColor() {
        maleView.setBackgroundColor(getBackgroundColor(selectedGender == "male"))
        femaleView.setBackgroundColor(getBackgroundColor(selectedGender == "female"))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference =
            if (isSelectedComponent) R.color.background_component_selected else R.color.background_component

        return ContextCompat.getColor(this, colorReference)
    }

    private fun calculateIMC(): Double {
        val decimalFormat = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100)
        return decimalFormat.format(imc).toDouble()
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

}