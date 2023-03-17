package com.example.a20230317_rajakalluru_nycschools.data

import com.google.gson.annotations.SerializedName

data class SatScore(
    @SerializedName("dbn")
    val dbn: String,

    @SerializedName("school_name")
    val schoolName: String,

    @SerializedName("num_of_sat_test_takers")
    val numberOfTestTakers: String,

    @SerializedName("sat_critical_reading_avg_score")
    val criticalReadingScore: String,

    @SerializedName("sat_math_avg_score")
    val mathScore: String,

    @SerializedName("sat_writing_avg_score")
    val writingScore: String
)
