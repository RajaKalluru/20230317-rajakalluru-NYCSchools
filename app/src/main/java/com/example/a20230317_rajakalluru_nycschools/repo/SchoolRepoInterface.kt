package com.example.a20230317_rajakalluru_nycschools.repo


import androidx.lifecycle.LiveData
import com.example.a20230317_rajakalluru_nycschools.data.SatScore
import com.example.a20230317_rajakalluru_nycschools.data.School

interface SchoolRepoInterface {
    fun getSchoolList(): LiveData<List<School>>
    fun getSatScoreList(): LiveData<List<SatScore>>
}
