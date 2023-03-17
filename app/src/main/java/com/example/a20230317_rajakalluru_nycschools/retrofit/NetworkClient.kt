package com.example.a20230317_rajakalluru_nycschools.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private var url = "https://data.cityofnewyork.us/resource/"

    private val retrofitClient: Retrofit.Builder by lazy {
        val okhttpClient = OkHttpClient.Builder()
        Retrofit.Builder()
            .baseUrl(url)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiCall by lazy {
        retrofitClient.build().create(ApiCall::class.java)
    }
}
