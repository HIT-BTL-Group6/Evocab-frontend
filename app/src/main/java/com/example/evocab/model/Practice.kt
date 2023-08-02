package com.example.evocab.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
class Practice(val id: String,
): Parcelable {
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Practice>(){
            override fun areItemsTheSame(oldItem: Practice, newItem: Practice) =
                oldItem.id ==newItem.id

            override fun areContentsTheSame(oldItem: Practice, newItem: Practice) =
                oldItem.id  == newItem.id
        }
    }
}