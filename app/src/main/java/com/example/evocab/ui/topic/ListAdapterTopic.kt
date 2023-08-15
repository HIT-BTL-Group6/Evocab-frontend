package com.example.evocab.ui.topic

import android.content.SharedPreferences
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemTopicBinding
import com.example.evocab.extension.loadImage
import com.example.evocab.model.DataTopicAPI
import com.example.sourcebase.base.BaseAdapter

class ListAdapterTopic(
    private val onClick: (DataTopicAPI) -> Unit,
): BaseAdapter<DataTopicAPI,BaseViewHolder<DataTopicAPI>>(DataTopicAPI.differUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DataTopicAPI> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTopicBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    inner class ViewHolder(val binding: ItemTopicBinding) :
        BaseViewHolder<DataTopicAPI>(binding) {
        override fun binView(item: DataTopicAPI) {
            super.binView(item)
            binding.root.setOnClickListener { onClick.invoke(item) }
            binding.apply {
                txtviewNameTopic.text = item.nameTopic
                //progressIn.progress = sharedPreferences.getStatus(item.na)
            }
        }
    }
}


