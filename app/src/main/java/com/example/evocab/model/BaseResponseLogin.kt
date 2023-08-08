package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class BaseResponseLogin(
    @SerializedName("status")
    val status: String?,
    val tokens: Tokens?,
)

data class Access(
    @SerializedName("token")
    val token: String?,
    @SerializedName("expires")
    val expires: String?,
)
data class Tokens(
    val access: Access?
)
