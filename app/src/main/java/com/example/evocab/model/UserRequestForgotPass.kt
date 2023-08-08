package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class UserRequestForgotPass(
    @SerializedName("email")
    val email: String
)