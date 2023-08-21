package com.example.evocab.ui.topic

import android.content.SharedPreferences
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.evocab.R
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
        private var isItemSelected = false
        override fun binView(item: DataTopicAPI, isItemSelected: Boolean) {

            binding.root.setOnClickListener { onClick.invoke(item)
                this.isItemSelected = isItemSelected
                updateSelectionState()
            }
            updateSelectionState()
            binding.apply {
                txtviewNameTopic.text = item.nameTopic

            }
        }
        private fun updateSelectionState() {
            if (isItemSelected) {
                binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.selected_item_background))
            } else {
                binding.root.setBackgroundColor(Color.TRANSPARENT) // hoặc màu nền mặc định
            }
        }

    }
}


