package com.example.a20230317_rajakalluru_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.a20230317_rajakalluru_nycschools.data.SatScore
import com.example.a20230317_rajakalluru_nycschools.data.School
import com.example.a20230317_rajakalluru_nycschools.repo.SchoolRepo

class SchoolViewModel : ViewModel() {
    private var schoolRepo: SchoolRepo = SchoolRepo()

    fun getSchoolList(): LiveData<List<School>> {
        return schoolRepo.getSchoolList()
    }

    fun getSatScoreList(): LiveData<List<SatScore>> {
        return schoolRepo.getSatScoreList()
    }
}
