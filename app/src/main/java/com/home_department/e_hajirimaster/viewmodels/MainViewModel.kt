package com.home_department.e_hajirimaster.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home_department.e_hajirimaster.entity.Demo
import com.home_department.e_hajirimaster.entity.Duty
import com.home_department.e_hajirimaster.remote.ApiClient
import com.home_department.e_hajirimaster.repository.Repository
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val repository: Repository = Repository(ApiClient.apiService)) : ViewModel() {

    private var _upcominDutyLiveData = MutableLiveData<List<Duty>>()
    val upcomingDutyLiveData : LiveData<List<Duty>>
    get() = _upcominDutyLiveData

    init {
        fetchUpcomingDuty()
    }

    private fun fetchUpcomingDuty(){
        val client = repository.getUpcomingDuty()
        client?.enqueue(object : retrofit2.Callback<Demo> {
            override fun onResponse(
                call: retrofit2.Call<Demo>,
                response: Response<Demo>
            ) {
                if (response.isSuccessful) {
                    _upcominDutyLiveData.postValue(response.body()?.Duties)
                }
            }
            override fun onFailure(
                call: Call<Demo>,
                t: Throwable
            ) {

            }
        }
        )
    }

}