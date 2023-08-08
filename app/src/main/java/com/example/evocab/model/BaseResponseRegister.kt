package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class BaseResponseRegister(
//    @SerializedName("status")
//    val status: String?,
//    val user: User?,
//    val code: Int?,
//    val message: String?
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: Data?
)

//data class User(
//    @SerializedName("role")
//    val role: String?,
//    @SerializedName("topicId")
//    val topicId: String?,
//    @SerializedName("username")
//    val username: String,
//    @SerializedName("email")
//    val email: String,
//    @SerializedName("id")
//    val id: String?,
//    @SerializedName("isActive")
//    val isActive: Boolean,
//    @SerializedName("isEmailVerified")
//    val isEmailVerified: Boolean,
//)



data class Data(
    @SerializedName("role")
    val role: String?,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("name")
    val username: String,
    @SerializedName("avatar")
    val avatar: String?
)
