package com.example.evocab.ui.topic

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemListFriendBinding
import com.example.evocab.databinding.ItemTopicBinding
import com.example.evocab.extension.loadImage
import com.example.evocab.model.Friend
import com.example.evocab.model.Topic
import com.example.sourcebase.base.BaseAdapter

class TopicAdapter(
    private val onClick: (Topic) -> Unit,
): BaseAdapter<Topic,BaseViewHolder<Topic>>(Topic.differUtil){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Topic> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTopicBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ItemTopicBinding) :
        BaseViewHolder<Topic>(binding) {
        override fun binView(item: Topic) {
            super.binView(item)
            binding.apply {
                tvTopicName.text = item.name
//                tvPercent
                imgTopic.loadImage(Uri.parse(item.img))
//                sbHomeTopi
            }
            binding.sbHomeTopic.isEnabled = false
        }
    }


}