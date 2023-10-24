package com.example.kotlinbasics.imcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinbasics.R
import com.example.kotlinbasics.imcalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}