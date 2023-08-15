package com.example.evocab.ui.missed

import android.util.Log
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.databinding.FragmentMissedBinding
import com.example.evocab.model.DataTopicAPI
import com.example.evocab.model.Vocabulary
import com.example.evocab.ui.classroom.ClassroomViewModel
import com.example.sourcebase.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MissedFragment : BaseFragment<FragmentMissedBinding>(FragmentMissedBinding::inflate) {
    private val vocabularyAdapter by lazy {
        ListAdapterVocabMissed(::onClick)
    }
    private var list: List<DataTopicAPI>? = null
    override val viewModel : MissedViewModel
        get() = ViewModelProvider(this)[MissedViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {

    }

    override fun handleEvent() {
        binding.imvMissedBack.setOnClickListener {
            findNavController().navigate(R.id.action_missedFragment_to_homeFragment)
        }
    }

    override fun bindData() {
        binding.btnMenu.setOnClickListener {
            showPopupMenu(it)
        }
//        viewModel.MissedResults.observe(viewLifecycleOwner){
//            Log.e("TopicFragment", "bindData: dữ liệu lấy liên tục: ${it} ", )
//            if(it!=null){
//                //list = it
//                binding.missedAdapter.adapter = vocabularyAdapter
//                binding.missedAdapter.layoutManager = LinearLayoutManager(context)
//                //vocabularyAdapter.submitList(it.hasItem())
//                Log.e("TopicFragment", "bindData: dữ liệu sau khi lấy: ${viewModel.MissedResults.value} ", )
//            }
//        }
//        //mẫu
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
                R.id.missedFragment -> {
                    binding.statusTopic.text = "Chưa nhớ"

                    true
                }
                R.id.img_remembered -> {
                    binding.statusTopic.text = "Đã nhớ"
                    // Xử lý khi người dùng chọn Item 2
                    true
                }
                R.id.flashCardFragment-> {
                    binding.statusTopic.text = "Chưa học"
//                     Xử lý khi người dùng chọn Item 3
//                    findNavController().navigate(R.id.mis)
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