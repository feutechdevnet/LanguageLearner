package com.example.languagelearner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class Quizzes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizzes)

        val backButton: Button = findViewById(R.id.backButton)

        backButton.setOnClickListener {
            // Navigate back to MainActivity (landing page)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Optionally, finish() to remove the current activity from the back stack
            finish()
        }
    }
}