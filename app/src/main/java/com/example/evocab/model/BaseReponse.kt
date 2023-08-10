package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class BaseReponse<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T?,
)
