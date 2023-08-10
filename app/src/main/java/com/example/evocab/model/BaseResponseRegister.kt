package com.example.evocab.model

import com.google.gson.annotations.SerializedName

//data class BaseResponseRegister(
//    @SerializedName("code")
//    val code: Int?,
//    @SerializedName("message")
//    val message: String,
//    @SerializedName("data")
//    val dataRegister: DataRegister?
//)
typealias BaseResponseRegister = BaseReponse<DataRegister>

data class DataRegister(
    @SerializedName("role")
    val role: String?,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String?,
    @SerializedName("username")
    val username: String,
    @SerializedName("topicId")
    val topicId: String?,
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean?
)
data class RegisterEnity(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String
)
