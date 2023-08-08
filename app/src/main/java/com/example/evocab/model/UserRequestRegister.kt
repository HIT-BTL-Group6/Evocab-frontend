package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class UserRequestRegister(
    @SerializedName("name")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("confirmPassword")
    val passwordAgian: String,
    @SerializedName("email")
    val email: String
)