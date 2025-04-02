package com.example.languagelearner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class Lessons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lessons)

        // Bind buttons using findViewById
        val engtoMandarin: Button = findViewById(R.id.engtoMandarin)
        val engtoHindi: Button = findViewById(R.id.engtoHindi)
        val engtoSpanish: Button = findViewById(R.id.engtoSpanish)

        // Set onClickListeners for each button
        engtoMandarin.setOnClickListener {
            // Start EnglishtoMandarin activity
            val intent = Intent(this, EnglishtoMandarin::class.java)
            startActivity(intent)
        }

        engtoHindi.setOnClickListener {
            // Start EnglishtoHindi activity
            val intent = Intent(this, EnglishtoHindi::class.java)
            startActivity(intent)
        }

        engtoSpanish.setOnClickListener {
            // Start EnglishtoSpanish activity
            val intent = Intent(this, EnglishtoSpanish::class.java)
            startActivity(intent)
        }
    }
}
