package com.example.kotlinbasics.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlinbasics.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nameTextView = findViewById<TextView>(R.id.text_view_name)

        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        nameTextView.text = "hola ${name}"
    }
}