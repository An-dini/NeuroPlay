package com.andini.neuroplay.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.andini.neuroplay.MainActivity
import com.andini.neuroplay.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, AuthActivity::class.java))
            finish()
        }, 3000)
    }
}