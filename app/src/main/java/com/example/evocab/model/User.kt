package com.example.evocab.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

typealias BaseReponseUser = BaseReponse<User>
@Parcelize
data class User(
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
    @SerializedName("emailExpires")
    val emailExpires: String?,
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("emailToken")
    val emailToken: String?,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean?
): Parcelable

