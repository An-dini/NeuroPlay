package com.andini.neuroplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.andini.neuroplay.view.Home
import com.andini.neuroplay.view.Profile
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationBar)

        if (intent.getBooleanExtra("transactionData", false)) {
            replaceFragment(Profile())
            bottomNavigationView.selectedItemId = R.id.profile
        } else {
            replaceFragment(Home())
            bottomNavigationView.selectedItemId = R.id.home
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(Home())
                    true
                }
                R.id.profile -> {
                    replaceFragment(Profile())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
        Log.d("MyApp", "Replacing fragment with ${fragment.javaClass.simpleName}")
    }
}