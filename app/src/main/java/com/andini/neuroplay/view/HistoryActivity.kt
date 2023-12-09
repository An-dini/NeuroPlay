package com.andini.neuroplay.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.andini.neuroplay.R

class HistoryActivity : AppCompatActivity() {
    private lateinit var lottieAnimationView: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setTitleTextColor(resources.getColor(R.color.blue))
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this@HistoryActivity, R.color.blue))

        lottieAnimationView = findViewById(R.id.lottieAnimationView)
        lottieAnimationView.setAnimation("data_not_found.json")
        lottieAnimationView.playAnimation()
        lottieAnimationView.loop(true)
        lottieAnimationView.speed = 1.0f
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}