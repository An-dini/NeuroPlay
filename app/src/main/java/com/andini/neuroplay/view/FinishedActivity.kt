package com.andini.neuroplay.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.andini.neuroplay.MainActivity
import com.andini.neuroplay.R

class FinishedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)

        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)
        val correctAnswers = intent.getIntExtra("CORRECT_ANSWERS", 0)
        val wrongAnswers = intent.getIntExtra("WRONG_ANSWERS", 0)

        val tvTotalQuestions = findViewById<TextView>(R.id.tvSumQuestion)
        val tvCorrectAnswers = findViewById<TextView>(R.id.tvCorrect)
        val tvWrongAnswers = findViewById<TextView>(R.id.tvWrong)

        tvTotalQuestions.text = "$totalQuestions"
        tvCorrectAnswers.text = "$correctAnswers"
        tvWrongAnswers.text = "$wrongAnswers"

        val btBack = findViewById<Button>(R.id.btBack)
        btBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}