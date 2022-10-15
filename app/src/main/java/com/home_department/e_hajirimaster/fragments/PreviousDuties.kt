package com.home_department.e_hajirimaster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.home_department.e_hajirimaster.R
import com.home_department.e_hajirimaster.adapters.PreviousDutyAdapter
import com.home_department.e_hajirimaster.adapters.UpcomingDutyAdapter
import com.home_department.e_hajirimaster.entity.Duty
import com.home_department.e_hajirimaster.viewmodels.MainViewModel

class PreviousDuties : Fragment(R.layout.previous_duties) {

    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUpcomingDuty(view)
    }

    private fun setUpRecyclerView(view: View, result: List<Duty>) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewPreviousDuty)
        val adapter = PreviousDutyAdapter(result)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = adapter
    }


    private fun getUpcomingDuty(view: View) {

        viewModel.upcomingDutyLiveData.observe(viewLifecycleOwner) {
            setUpRecyclerView(view, it)
        }
    }
}