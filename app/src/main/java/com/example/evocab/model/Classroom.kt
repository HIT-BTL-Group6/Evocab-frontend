package com.example.evocab.model
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize


@Parcelize
data class Classroom(
    val id: Int,
    val name: String?,
    val img_avt: String?,
    val status: Boolean?
): Parcelable {
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Classroom>(){
            override fun areItemsTheSame(oldItem: Classroom, newItem: Classroom) =
                oldItem.id ==newItem.id

            override fun areContentsTheSame(oldItem: Classroom, newItem: Classroom) =
                oldItem.id  == newItem.id
        }
    }
}
