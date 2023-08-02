package com.example.evocab.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemListFriendBinding
import com.example.evocab.model.Friend
import com.example.sourcebase.base.BaseAdapter

class ProfileAdapter(
    private val onClick: (Friend) -> Unit,
) : BaseAdapter<Friend,BaseViewHolder<Friend>>(Friend.differUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Friend> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListFriendBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    inner class ViewHolder(val binding: ItemListFriendBinding) :
        BaseViewHolder<Friend>(binding) {
        override fun binView(item: Friend) {
            super.binView(item)
            binding.apply {
                // gán giá trị cho các đối số ở đây
                textView5.text = item.name
            }
        }
    }
}
