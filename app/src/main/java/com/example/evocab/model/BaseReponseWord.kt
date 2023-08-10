package com.example.evocab.model

import com.google.gson.annotations.SerializedName

typealias BaseReponseWord = BaseReponse<Word>

data class Word(
    @SerializedName("word")
    val word: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("sound")
    val sound: String?,
    @SerializedName("pronunciation")
    val pronunciation: String?,
    @SerializedName("example")
    val example: String,
    @SerializedName("vietnamese")
    val vietnamese: String,
    @SerializedName("nameTopic")
    val nameTopic: String,
    @SerializedName("id")
    val id: String,
)

