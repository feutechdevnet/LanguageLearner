package com.example.languagelearner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lessonsButton: Button = findViewById(R.id.lessonsButton)
        val quizzesButton: Button = findViewById(R.id.quizzesButton)
        val communityButton: Button = findViewById(R.id.communityButton)

        lessonsButton.setOnClickListener {
            val intent = Intent(this, Lessons::class.java)
            startActivity(intent)
        }

        quizzesButton.setOnClickListener {
            val intent = Intent(this, Quizzes::class.java)
            startActivity(intent)
        }

        communityButton.setOnClickListener {
            val intent = Intent(this, Community::class.java)
            startActivity(intent)
        }
    }
}