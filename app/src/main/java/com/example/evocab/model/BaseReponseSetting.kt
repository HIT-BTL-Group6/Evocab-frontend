package com.example.evocab.model

import com.google.gson.annotations.SerializedName

typealias BaseReponseSetting = BaseReponse<ChangeUser>

data class ChangeUser(
    @SerializedName("")
    val name: String?
)
