package com.example.evocab.ui.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemQuesGridBinding
import com.example.evocab.model.Practice
import com.example.sourcebase.base.BaseAdapter

class ListAdapterExam(private val onClick: (Practice) -> Unit):
    BaseAdapter<Practice, BaseViewHolder<Practice>>(Practice.differUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Practice> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemQuesGridBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    inner class ViewHolder(val binding: ItemQuesGridBinding) :
        BaseViewHolder<Practice>(binding) {
        override fun binView(item: Practice) {
            super.binView(item)
            binding.apply {
                number.text = item.id
            }
        }
    }


}