package com.example.evocab.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.evocab.data.database.DataBaseLocal
import com.google.gson.annotations.SerializedName

typealias BaseReponseWord = BaseReponse<Word>
typealias ListWord = BaseReponse<List<Word>>

@Entity(tableName = DataBaseLocal.TABLE_WORD)

data class Word(
    @SerializedName("note")
    val note: String? = null,
    @SerializedName("word")
    val word: String,
    @SerializedName("image")
    val image: String?,
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
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: String,
)

data class WordRemember(
    @SerializedName("sound")
    val idUser: String?,
    val idWord: String?,
    val isRemember: Boolean?,
    val note: String?
)


