package com.example.evocab.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic(
    val id: Int,
    val name: String?,
    val img: String?
): Parcelable {
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Topic>(){
            override fun areItemsTheSame(oldItem: Topic, newItem: Topic) =
                oldItem.id ==newItem.id

            override fun areContentsTheSame(oldItem: Topic, newItem: Topic) =
                oldItem.id  == newItem.id
        }
    }
}