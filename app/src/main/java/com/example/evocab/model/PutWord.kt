package com.example.evocab.model

import com.google.gson.annotations.SerializedName

typealias PutWord = BaseReponse<DataPuWord>

data class DataPuWord(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("words")
    val words: List<Words>?
)
data class Words(
    @SerializedName("isRemember")
    val isRemember: Boolean?,
    @SerializedName("note")
    val note: String?,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("wordId")
    val wordId: String,
)
