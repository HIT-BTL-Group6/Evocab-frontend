package com.example.evocab.model

import com.google.gson.annotations.SerializedName

//data class BaseResponseLogin(
//    @SerializedName("code")
//    val code: Int,
//    @SerializedName("message")
//    val message: String,
//    @SerializedName("data")
//    val dataToken: DataToken?,
//)
typealias BaseResponseLogin = BaseReponse<DataToken>

data class LoginEnity(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
)

data class Access(
    @SerializedName("token")
    val token: String,
    @SerializedName("expires")
    val expires: String?,
)
data class DataToken(
    val access: Access
)

