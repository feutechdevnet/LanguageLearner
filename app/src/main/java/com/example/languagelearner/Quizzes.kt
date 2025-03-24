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

        val quizMandarin: Button = findViewById(R.id.quizMandarin)
        val quizHindi: Button = findViewById(R.id.quizHindi)
        val quizSpanish: Button = findViewById(R.id.quizSpanish)

        quizMandarin.setOnClickListener {
            val intent = Intent(this, QuizMandarin::class.java)
            startActivity(intent)
        }

        quizHindi.setOnClickListener {
            val intent = Intent(this, QuizHindi::class.java)
            startActivity(intent)
        }

        quizSpanish.setOnClickListener {
            val intent = Intent(this, QuizSpanish::class.java)
            startActivity(intent)
        }
    }
}