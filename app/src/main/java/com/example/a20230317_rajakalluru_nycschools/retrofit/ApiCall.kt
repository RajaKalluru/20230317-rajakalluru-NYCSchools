package com.example.a20230317_rajakalluru_nycschools.retrofit

import com.example.a20230317_rajakalluru_nycschools.data.SatScore
import com.example.a20230317_rajakalluru_nycschools.data.School
import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("s3k6-pzi2")
    fun getSchoolList(): Call<List<School>>

    @GET("f9bf-2cp4")
    fun getSatScores(): Call<List<SatScore>>
}
