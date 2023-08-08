package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class BaseResponseLogin(
//    @SerializedName("status")
//    val status: String?,
//    val tokens: Tokens?,
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: String?,

)

//data class Access(
//    @SerializedName("token")
//    val token: String?,
//    @SerializedName("expires")
//    val expires: String?,
//)
//data class Tokens(
//    val access: Access?
//)

