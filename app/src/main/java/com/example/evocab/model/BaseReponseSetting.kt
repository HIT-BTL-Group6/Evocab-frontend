package com.example.evocab.model

import com.google.gson.annotations.SerializedName

typealias BaseReponseSetting = BaseReponse<ChangeUser>

data class ChangeUser(
    @SerializedName("role")
    val role: String?,
    @SerializedName("topicId")
    val topicId: String?,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: String?
)

