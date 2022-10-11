package com.home_department.e_hajirimaster.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.home_department.e_hajirimaster.entity.Demo
import com.home_department.e_hajirimaster.entity.Duty
import com.home_department.e_hajirimaster.R
import com.home_department.e_hajirimaster.UpcomingDutyAdapter
import com.home_department.e_hajirimaster.remote.ApiClient
import retrofit2.Call
import retrofit2.Response


class UpcomingDuties : Fragment(R.layout.upcoming_duties) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.upcoming_duties, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUpcomingDuty(view)

    }

    private fun setupRecyclerView(result: List<Duty>, view: View) {
        val adapter = UpcomingDutyAdapter(result)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = adapter
    }

    private fun getUpcomingDuty(view: View) {

        val client = ApiClient.apiService?.fetchCharacters()
        client?.enqueue(object : retrofit2.Callback<Demo> {
            override fun onResponse(
                call: Call<Demo>,
                response: Response<Demo>
            ) {
                if (response.isSuccessful) {

                    val result = response.body()?.Duties
                    result?.let {
                        Log.d("abc", response.body().toString() + "" + result[1])
                        setupRecyclerView(result, view)
                        //setting up recyclerview
                    }
                }
            }

            override fun onFailure(
                call: Call<Demo>,
                t: Throwable
            ) {
                Log.d("fail", "he")
                Toast.makeText(context, "Unsuccessful", Toast.LENGTH_SHORT).show()
            }
        }
        )

    }

}


//settingup recyclerview
//                        val adapter = UpcomingDutyAdapter(result)
//
//                        recyclerView?.layoutManager = LinearLayoutManager(context)
//                        recyclerView?.adapter = adapter