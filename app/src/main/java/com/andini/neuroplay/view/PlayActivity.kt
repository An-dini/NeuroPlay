package com.andini.neuroplay.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.andini.neuroplay.R

class PlayActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer
    private var currentQuestionIndex = 0
    private val questions = mutableListOf<Pair<String, List<String>>>()
    private lateinit var textViewTimer: TextView
    private lateinit var btnAnswerA: CardView
    private lateinit var btnAnswerB: CardView
    private lateinit var btnAnswerC: CardView
    private lateinit var btnAnswerD: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        initializeQuestions()
        textViewTimer = findViewById(R.id.tvTimer)
        btnAnswerA = findViewById(R.id.cvAnswerA)
        btnAnswerB = findViewById(R.id.cvAnswerB)
        btnAnswerC = findViewById(R.id.cvAnswerC)
        btnAnswerD = findViewById(R.id.cvAnswerD)

        showNextQuestion()
        startTimer()

        btnAnswerA.setOnClickListener { onAnswerClicked(findViewById<TextView>(R.id.tvAnsA).text.toString()) }
        btnAnswerB.setOnClickListener { onAnswerClicked(findViewById<TextView>(R.id.tvAnsB).text.toString()) }
        btnAnswerC.setOnClickListener { onAnswerClicked(findViewById<TextView>(R.id.tvAnsC).text.toString()) }
        btnAnswerD.setOnClickListener { onAnswerClicked(findViewById<TextView>(R.id.tvAnsD).text.toString()) }

    }

    private fun initializeQuestions(){
        val question1Options = mutableListOf("15", "12", "20", "18").shuffled()
        questions.add(Pair("10 + 5", question1Options))

        val question2Options = mutableListOf("690", "650", "750", "600").shuffled()
        questions.add(Pair("30 x 23", question2Options))

        val question3Options = mutableListOf("33", "27", "30", "36").shuffled()
        questions.add(Pair("99 / 3", question3Options))

        val question4Options = mutableListOf("5", "7", "8", "6").shuffled()
        questions.add(Pair("10 - 5", question4Options))
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex < questions.size) {
            val currentQuestion = questions[currentQuestionIndex].first
            val options = questions[currentQuestionIndex].second

            findViewById<TextView>(R.id.tvQuestion).text = currentQuestion

            btnAnswerA.findViewById<TextView>(R.id.tvAnsA)?.setText(options[0])
            btnAnswerB.findViewById<TextView>(R.id.tvAnsB)?.setText(options[1])
            btnAnswerC.findViewById<TextView>(R.id.tvAnsC)?.setText(options[2])
            btnAnswerD.findViewById<TextView>(R.id.tvAnsD)?.setText(options[3])
        } else {
            goToResultPage()
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                textViewTimer.text = "$secondsRemaining"
            }
            override fun onFinish() {
                goToResultPage()
            }
        }
        timer.start()
    }

    private fun goToResultPage() {
        val intent = Intent(this, FinishedActivity::class.java)
        intent.putExtra("TOTAL_QUESTIONS", questions.size)
        intent.putExtra("CORRECT_ANSWERS", correctAnswers)
        intent.putExtra("WRONG_ANSWERS", wrongAnswers)
        startActivity(intent)
        timer.cancel()
        finish()
    }

    private fun onAnswerClicked(selectedAnswer: String) {
        val correctAnswer = questions[currentQuestionIndex].second[0]
        val isCorrect = selectedAnswer == correctAnswer
        updateMarkText(isCorrect)

        currentQuestionIndex++
        showNextQuestion()
        timer.cancel()
        startTimer()
    }

    private var correctAnswers = 0
    private var wrongAnswers = 0

    private fun updateMarkText(isCorrect: Boolean) {
        val totalQuestions = questions.size

        if (isCorrect) {
            correctAnswers++
        } else {
            wrongAnswers++
        }

        val markText = "Correct: $correctAnswers / Wrong: $wrongAnswers"

        findViewById<TextView>(R.id.tvMark)?.text = markText
    }
}