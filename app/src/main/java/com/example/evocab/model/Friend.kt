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
        val differUtil = object : DiffUtil.ItemCallback<Vocabulary>(){
            override fun areItemsTheSame(oldItem: Vocabulary, newItem: Vocabulary) =
                oldItem.id ==newItem.id

            override fun areContentsTheSame(oldItem: Vocabulary, newItem: Vocabulary) =
                oldItem.id  == newItem.id
        }
    }
}

