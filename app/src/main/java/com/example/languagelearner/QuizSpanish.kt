package com.example.languagelearner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.view.View
import com.example.languagelearner.QuizHindi.Question

class QuizSpanish : AppCompatActivity() {

    private var score = 0
    private var currentQuestionIndex = 0
    private val questions = listOf(
        Question("What is the Spanish term for 'Hello'?", "Hola", "Gracias", "Hola"),
        Question("What is the Spanish term for 'Thank you'?", "Hola", "Gracias", "Gracias"),
        Question("What is the Spanish term for 'Good morning'?", "Adiós", "Buenos días", "Buenos días"),
        Question("What is the Spanish term for 'Goodbye'?", "Adiós", "Sí", "Adiós"),
        Question("What is the Spanish term for 'Yes'?", "Sí", "Por favor", "Sí")
    )

    private lateinit var scoreTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var answerButton1: Button
    private lateinit var answerButton2: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_spanish)

        // Initialize views
        scoreTextView = findViewById(R.id.scoreTextView)
        questionTextView = findViewById(R.id.questionTextView)
        answerButton1 = findViewById(R.id.answerButton1)
        answerButton2 = findViewById(R.id.answerButton2)
        resetButton = findViewById(R.id.resetButton)

        // Set up buttons' onClickListeners
        answerButton1.setOnClickListener { checkAnswer(answerButton1.text.toString()) }
        answerButton2.setOnClickListener { checkAnswer(answerButton2.text.toString()) }
        resetButton.setOnClickListener { resetQuiz() }


        // Initialize the quiz question
        loadQuestion()
    }

    private fun loadQuestion() {
        val currentQuestion = questions[currentQuestionIndex]
        questionTextView.text = currentQuestion.question
        answerButton1.text = currentQuestion.answer1
        answerButton2.text = currentQuestion.answer2
        questionTextView.text = "Question ${currentQuestionIndex + 1} of 5: ${currentQuestion.question}"

    }

    private fun checkAnswer(selectedAnswer: String) {
        val correctAnswer = questions[currentQuestionIndex].correctAnswer
        if (selectedAnswer == correctAnswer) {
            score++
        }

        // Update score
        updateScore()

        // Move to the next question
        currentQuestionIndex++

        if (currentQuestionIndex < questions.size) {
            loadQuestion()
        } else {
            showQuizFinished()
        }
    }

    private fun updateScore() {
        scoreTextView.text = "Score: $score"
    }

    private fun resetQuiz() {
        score = 0
        currentQuestionIndex = 0
        updateScore()

        // Make the answer buttons visible again
        answerButton1.visibility = View.VISIBLE
        answerButton2.visibility = View.VISIBLE

        // Reset the question and button text
        loadQuestion()

        // Reset the reset button text to "Restart"
        resetButton.text = "Restart Quiz"
    }

    private fun showQuizFinished() {
        questionTextView.text = "Quiz Finished!"
        answerButton1.visibility = View.GONE
        answerButton2.visibility = View.GONE
        resetButton.text = "Restart Quiz"
    }

    data class Question(val question: String, val answer1: String, val answer2: String, val correctAnswer: String)
}