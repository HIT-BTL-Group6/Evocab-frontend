package com.example.evocab.ui.missed

import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentMissedBinding
import com.example.evocab.model.Vocabulary
import com.example.sourcebase.base.BaseFragment

class MissedFragment : BaseFragment<FragmentMissedBinding>(FragmentMissedBinding::inflate) {
    private val vocabularyAdapter by lazy {
        ListAdapterVocabMissed(::onClick)
    }
    override val viewModel: MissedViewModel
        get() = ViewModelProvider(this)[MissedViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {
        //mẫu
        val v1:Vocabulary = Vocabulary("1", "mother", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val v2:Vocabulary = Vocabulary("2", "father", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val v3:Vocabulary = Vocabulary("3", "sister", "sdsdfs", "Fsfsd", "SDfsd", false, "dfsf")
        val vocabs= listOf(v1, v2, v3)
        vocabularyAdapter.submitList(vocabs)
        binding.missedAdapter.layoutManager =LinearLayoutManager(context)
        binding.missedAdapter.adapter = vocabularyAdapter

    }


    private fun onClick(vocabulary: Vocabulary) {
        Toast.makeText(context, "Item lớn", Toast.LENGTH_SHORT).show()
        Log.e("chạm", "đã chạm item")
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(context, view)
        popupMenu.inflate(R.menu.menu_type_vocabulary)

        popupMenu.setOnMenuItemClickListener {it->
            when (it.itemId) {
                R.id.missed -> {
                    findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
                    true
                }
                R.id.remembered -> {
                    // Xử lý khi người dùng chọn Item 2
                    true
                }
                R.id.new_vocabulary -> {
                    // Xử lý khi người dùng chọn Item 3
                    true
                }
                // Xử lý các item khác (nếu cần)
                else -> false
            }
        }

        // Hiển thị Popup Menu
        popupMenu.show()
    }

}