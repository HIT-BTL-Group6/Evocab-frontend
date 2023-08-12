package com.example.evocab.model

import com.google.gson.annotations.SerializedName

data class BaseReponseMissed(
    @SerializedName("id")
    val id: String?,
    val data: List<DataAPIMissed>?
)
data class DataAPIMissed(
    @SerializedName("id")
    val idD: String?
)
