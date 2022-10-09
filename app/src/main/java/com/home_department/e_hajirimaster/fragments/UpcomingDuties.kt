package com.home_department.e_hajirimaster.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.home_department.e_hajirimaster.ApiClient
import com.home_department.e_hajirimaster.Demo
import com.home_department.e_hajirimaster.R
import com.home_department.e_hajirimaster.UpcomingDutyAdapter

import retrofit2.Call
import retrofit2.Response


class UpcomingDuties : Fragment(R.layout.upcoming_duties) {


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView= view.findViewById<RecyclerView>(R.id.recyclerView)

        val client = ApiClient.apiService?.fetchCharacters()

        client?.enqueue(object  : retrofit2.Callback<Demo>{
            override fun onResponse(
                call : Call<Demo>,
                response : Response<Demo>
            ){
                if (response.isSuccessful){

                    val result = response.body()?.Duties
                    result?.let {
                        Log.d("abc", response.body().toString()+""+result[1])
                        val adapter = UpcomingDutyAdapter(result)

                        recyclerView?.layoutManager= LinearLayoutManager(context)
                        recyclerView?.adapter=adapter
                    }

                }

            }
            override fun onFailure(
                call : Call<Demo>,
                t : Throwable
            ){
                Log.d("fail","hehehehehe")
//                Toast.makeText(this,"Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }
        )
    }

}