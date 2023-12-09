package com.andini.neuroplay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andini.neuroplay.R
import com.andini.neuroplay.viewmodel.ProfileMenuAdapter

class Profile : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var profileMenuAdapter: ProfileMenuAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val menuList = listOf("Edit Profile", "Edit Password", "Logout")
        profileMenuAdapter = ProfileMenuAdapter(menuList)
        recyclerView.adapter = profileMenuAdapter

        return view
    }
}