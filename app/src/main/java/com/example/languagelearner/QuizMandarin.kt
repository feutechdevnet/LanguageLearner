package com.example.languagelearner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.TextView




class QuizMandarin : AppCompatActivity() {

    // Declare question list
    private val questions = listOf(
        Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),
        Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "Mars"),
        Question("Who wrote 'Romeo and Juliet'?", "Shakespeare", "Dickens", "Hemingway", "Twain", "Shakespeare"),
        Question("What is the largest ocean on Earth?", "Atlantic", "Pacific", "Indian", "Arctic", "Pacific"),
        Question("Who painted the Mona Lisa?", "Van Gogh", "Da Vinci", "Picasso", "Rembrandt", "Da Vinci"),
        Question("What is the tallest mountain in the world?", "K2", "Everest", "Kangchenjunga", "Makalu", "Everest"),
        Question("What is the capital of Japan?", "Beijing", "Seoul", "Tokyo", "Bangkok", "Tokyo"),
        Question("What is the smallest continent?", "Asia", "Africa", "Australia", "Antarctica", "Australia"),
        Question("Which element has the chemical symbol O?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"),
        Question("Who developed the theory of relativity?", "Newton", "Einstein", "Bohr", "Curie", "Einstein")
    )
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_mandarin)

            // Get references to views
            val questionText = findViewById<TextView>(R.id.question_text)
            val choicesGroup = findViewById<RadioGroup>(R.id.choices_group)
            val submitButton = findViewById<Button>(R.id.submit_button)

            // Function to load the current question
            fun loadQuestion() {
                val currentQuestion = questions[currentQuestionIndex]
                questionText.text = currentQuestion.question

                // Loop through choices and assign to RadioButtons
                choicesGroup.children.forEachIndexed { index, view ->
                    (view as RadioButton).text = when (index) {
                        0 -> currentQuestion.choice1
                        1 -> currentQuestion.choice2
                        2 -> currentQuestion.choice3
                        3 -> currentQuestion.choice4
                        else -> ""
                    }
                }
            }
            // Set up button click listener
            submitButton.setOnClickListener {
                val selectedRadioButtonId = choicesGroup.checkedRadioButtonId
                if (selectedRadioButtonId == -1) {
                    // No choice selected
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                } else {
                    val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                    val selectedAnswer = selectedRadioButton.text.toString()

                    // Check if the selected answer is correct
                    if (selectedAnswer == questions[currentQuestionIndex].correctAnswer) {
                        score++
                        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Incorrect. The correct answer is ${questions[currentQuestionIndex].correctAnswer}.", Toast.LENGTH_SHORT).show()
                    }

                    // Move to the next question
                    currentQuestionIndex++
                    if (currentQuestionIndex < questions.size) {
                        loadQuestion()
                    } else {
                        // End of quiz
                        Toast.makeText(this, "Quiz finished! Your score: $score/${questions.size}", Toast.LENGTH_LONG).show()
                        currentQuestionIndex = 0
                        score = 0
                        loadQuestion() // Reload the first question again
                    }
                }
            }

            // Load the first question
            loadQuestion()
        }

        // Question data class to hold the question, choices, and the correct answer
        data class Question(
            val question: String,
            val choice1: String,
            val choice2: String,
            val choice3: String,
            val choice4: String,
            val correctAnswer: String
        )
    }