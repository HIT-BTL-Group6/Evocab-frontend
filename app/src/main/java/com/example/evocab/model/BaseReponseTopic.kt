package com.example.evocab.model

import android.os.Parcelable
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

typealias BaseReponseTopic = BaseReponse<List<DataTopicAPI>>

@Parcelize
data class DataTopicAPI(
    @SerializedName("nameTopic")
    val nameTopic: String?,
    @SerializedName("id")
    val idTopic: String,
    @SerializedName("words")
    val listIdWord: List<String>?
) : Parcelable{
    companion object {
        val differUtil = object : DiffUtil.ItemCallback<DataTopicAPI>(){
            override fun areItemsTheSame(oldItem: DataTopicAPI, newItem: DataTopicAPI): Boolean {
                 Log.e("TAG", "areItemsTheSame:1 ", )
                return oldItem.idTopic == newItem.idTopic
            }

            override fun areContentsTheSame(oldItem: DataTopicAPI, newItem: DataTopicAPI): Boolean {
                Log.e("TAG", "areItemsTheSame:2 ", )
                return oldItem.idTopic == newItem.idTopic
            }
        }
    }
}
