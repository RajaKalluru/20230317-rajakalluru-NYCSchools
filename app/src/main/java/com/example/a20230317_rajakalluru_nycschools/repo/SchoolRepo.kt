package com.example.a20230317_rajakalluru_nycschools.repo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a20230317_rajakalluru_nycschools.data.SatScore
import com.example.a20230317_rajakalluru_nycschools.data.School
import com.example.a20230317_rajakalluru_nycschools.retrofit.NetworkClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolRepo : SchoolRepoInterface {
    override fun getSchoolList(): LiveData<List<School>> {
        val data = MutableLiveData<List<School>>()
        val apiCall = NetworkClient.apiInterface.getSchoolList()
        apiCall.enqueue(object : Callback<List<School>> {
            override fun onResponse(call: Call<List<School>>, response: Response<List<School>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }

    override fun getSatScoreList(): LiveData<List<SatScore>> {
        val data = MutableLiveData<List<SatScore>>()
        val apiCall = NetworkClient.apiInterface.getSatScores()
        apiCall.enqueue(object : Callback<List<SatScore>> {
            override fun onResponse(
                call: Call<List<SatScore>>,
                response: Response<List<SatScore>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<SatScore>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}
