package com.andini.neuroplay.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.andini.neuroplay.MainActivity
import com.andini.neuroplay.R

class Login : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val btnRegister = view.findViewById<Button>(R.id.btnLogin)

        btnRegister.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        return view
    }
}