package com.example.evocab.ui.classroom

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemClassroomBinding
import com.example.evocab.extension.loadImage
import com.example.evocab.model.Classroom
import com.example.sourcebase.base.BaseAdapter

class ListClassAdapter(private val onClick: (Classroom) -> Unit) :
    BaseAdapter<Classroom,BaseViewHolder<Classroom>>(Classroom.differUtil){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Classroom> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemClassroomBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    // sửa viiew holder
    inner class ViewHolder(val binding: ItemClassroomBinding) :
        BaseViewHolder<Classroom>(binding) {
        override fun binView(item: Classroom, isItemSelected: Boolean) {
            super.binView(item, isItemSelected)
            binding.apply {
                tvClassroomName.text = item.name
                imvAvtClassroom.loadImage(Uri.parse(item.img_avt))
            }
        }
    }
}