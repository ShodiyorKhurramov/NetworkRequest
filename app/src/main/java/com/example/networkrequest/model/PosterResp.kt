package com.example.networkrequest.model

import com.google.gson.annotations.SerializedName

data class PosterResp(
    @SerializedName("id")
    val id : Int =0,
    @SerializedName("userId")
    val userID : Int =0,
    @SerializedName("title")
    val title: String?=null,
    @SerializedName("body")
    val body : String ?=null,

)
