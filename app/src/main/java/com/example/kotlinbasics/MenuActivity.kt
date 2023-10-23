package com.example.kotlinbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlinbasics.firstapp.FirstAppActivity
import com.example.kotlinbasics.imcalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val firstAppButton = findViewById<Button>(R.id.button_first_app)
        val imcAppButton = findViewById<Button>(R.id.button_imc_app)


        firstAppButton.setOnClickListener { navigateToFirstApp() }

        imcAppButton.setOnClickListener { navigateToImcApp() }
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToFirstApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}