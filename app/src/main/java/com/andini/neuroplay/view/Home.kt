package com.andini.neuroplay.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.andini.neuroplay.R
class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val cvPlay = view.findViewById<CardView>(R.id.cvPlay)
        val cvHistory = view.findViewById<CardView>(R.id.cvHistory)
        val cvAbout = view.findViewById<CardView>(R.id.cvAbout)


        cvPlay.setOnClickListener {
            startActivity(Intent(requireContext(), PlayActivity::class.java))
        }
        cvHistory.setOnClickListener {
            startActivity(Intent(requireContext(), HistoryActivity::class.java))
        }
        cvAbout.setOnClickListener {
            startActivity(Intent(requireContext(), AboutActivity::class.java))
        }

        return view
    }
}