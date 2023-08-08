package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class UserRequestLogin(
    @SerializedName("email")
    val username: String,
    @SerializedName("password")
    val password: String,
)
