package com.example.a20230317_rajakalluru_nycschools.data


import com.google.gson.annotations.SerializedName

data class School(
    @SerializedName("dbn")
    val dbn: String,

    @SerializedName("school_name")
    val schoolName: String,

    @SerializedName("boro")
    val boro: String,

    @SerializedName("overview_paragraph")
    val description: String
)
