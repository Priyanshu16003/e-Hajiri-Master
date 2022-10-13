package com.home_department.e_hajirimaster.entity

import com.squareup.moshi.Json

data class Duty(
    @Json()
    val d_info: String,
    val d_type: String,
    val date: String,
    val end_time: String,
    val start_time: String
)