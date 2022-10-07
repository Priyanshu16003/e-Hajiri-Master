package com.home_department.e_hajirimaster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.home_department.e_hajirimaster.R
import com.home_department.e_hajirimaster.databinding.ActivityMainBinding
import com.home_department.e_hajirimaster.databinding.UpcomingDutiesBinding


class UpcomingDuties : Fragment(R.layout.upcoming_duties) {


lateinit var binding: UpcomingDutiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.upcoming_duties, container, false)
    }



}