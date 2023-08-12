package com.example.evocab.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vocabulary(
    val id: String,
    val wordEnglish: String,
    val wordVietnames: String,
    val typeWord: String,
    val pronounce: String?,
    val isNoted: Boolean?,
    val Note: String?
):Parcelable{
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Vocabulary>(){
            override fun areItemsTheSame(oldItem: Vocabulary, newItem: Vocabulary) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Vocabulary, newItem: Vocabulary) =
                oldItem.id  == newItem.id
        }
    }
}

