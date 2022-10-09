package com.home_department.e_hajirimaster

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object ApiClient {

    private val base_url= "https://ssiptm000405.hasura.app/api/rest/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit : Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val apiService: ApiService? by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService{
    @GET("duties")
    fun fetchCharacters() : Call<Demo>

//    @GET("character/{id}")
//    fun fetchindividual(@Path("id") charId : Int) : Call<>

}