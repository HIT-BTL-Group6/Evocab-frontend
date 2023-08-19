package com.example.evocab.ui.missed


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.databinding.ItemVovabularyBinding
import com.example.evocab.model.Vocabulary
import com.example.sourcebase.base.BaseAdapter

class ListAdapterVocabMissed(private val onClick: (Vocabulary) -> Unit) :
    BaseAdapter<Vocabulary, BaseViewHolder<Vocabulary>>(Vocabulary.differUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Vocabulary> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVovabularyBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    inner class ViewHolder(val binding: ItemVovabularyBinding) :
        BaseViewHolder<Vocabulary>(binding) {

        override fun binView(item: Vocabulary, isItemSelected: Boolean) {
            super.binView(item, isItemSelected)
            binding.apply {
                idItem.text = item.id+"/"
                wordEnglish.text = item.wordEnglish
                meaning.text = item.wordVietnames
                typeWord.text = "("+item.typeWord+")"
                root.setOnClickListener {
                    onClick(item)
                }
                noted.setOnClickListener {
                    Log.e("chạm", "đã chạm noted")
                }
            }
        }
    }


}