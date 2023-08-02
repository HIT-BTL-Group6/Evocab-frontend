package com.example.evocab.model
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend(
    val id: Int,
    val name: String?,
    val img_avt: String?
): Parcelable{
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Friend>(){
            override fun areItemsTheSame(oldItem: Friend, newItem: Friend) =
                oldItem.id ==newItem.id

            override fun areContentsTheSame(oldItem: Friend, newItem: Friend) =
                oldItem.id  == newItem.id
        }
    }
}

