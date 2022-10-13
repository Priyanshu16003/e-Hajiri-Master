package com.home_department.e_hajirimaster.repository

import com.home_department.e_hajirimaster.remote.ApiService

class Repository(private val apiService: ApiService?) {
    fun getUpcomingDuty() = apiService?.fetchUpcomingDuty()
}