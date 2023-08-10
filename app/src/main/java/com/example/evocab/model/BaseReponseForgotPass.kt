package com.example.evocab.model

import com.google.gson.annotations.SerializedName

//data class BaseReponseForgotPass(
//    @SerializedName("code")
//    val code: Int,
//    @SerializedName("message")
//    val message: String,
//    @SerializedName("data")
//    val data: String?,
//)
typealias BaseReponseForgotPass = BaseReponse<String>


data class ForgotPassEnity(
    @SerializedName("email")
    val email: String
)

