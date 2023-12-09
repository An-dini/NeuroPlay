package com.andini.neuroplay.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.andini.neuroplay.R

class HistoryActivity : AppCompatActivity() {
    private lateinit var lottieAnimationView: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        supportActionBar?.show()

        lottieAnimationView = findViewById(R.id.lottieAnimationView)
        lottieAnimationView.setAnimation("data_not_found.json")
        lottieAnimationView.playAnimation()
        lottieAnimationView.loop(true)
        lottieAnimationView.speed = 1.0f
    }
}