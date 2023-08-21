package com.example.evocab.ui.topic

import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.atom.android.lebo.utils.extensions.getStatus
import com.atom.android.lebo.utils.extensions.saveIdTopic
import com.example.evocab.R
import com.example.evocab.databinding.FragmentTopicBinding
import com.example.evocab.extension.hasItem
import com.example.evocab.model.DataTopicAPI
import com.example.evocab.model.Practice
import com.example.evocab.model.Topic
import com.example.evocab.ui.exam.ListAdapterExam
import com.example.sourcebase.base.BaseFragment
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopicFragment :BaseFragment<FragmentTopicBinding>(FragmentTopicBinding::inflate) {

    // cái này để làm gì
    private val topicAdapter by lazy {
        ListAdapterTopic(::onClick)
    }

    private val sharedPreferences = get<SharedPreferences>()

    private var list: List<DataTopicAPI>? = null

    override val viewModel by viewModel<TopicViewModel>()


    override fun destroy() {
        super.onDestroy()

    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.imgFind.setOnClickListener {
            val nameTopicFind = binding.edtFind.text.toString()

            Log.e("TAG", "handleEvent: ${nameTopicFind}", )
            // Tạo danh sách mới để lưu các item tìm kiếm được
            val filteredList = list?.filter { dataTopicAPI ->
                dataTopicAPI.nameTopic?.contains(nameTopicFind, ignoreCase = true) == true
            }
            if (filteredList.isNullOrEmpty()) {
                topicAdapter.submitList(filteredList?.hasItem())
                binding.txtviewErrorNotFound.visibility = View.VISIBLE
                Log.e("TopicFragment", "Không tìm thấy kết quả cho \"$nameTopicFind\"")
            } else {
                // Cập nhật dữ liệu trong adapter với danh sách tìm kiếm
                binding.txtviewErrorNotFound.visibility = View.GONE
                topicAdapter.submitList(filteredList?.hasItem())
            }
        }
        binding.imgTopicBack.setOnClickListener {
            findNavController().navigate(R.id.action_topicFragment_to_homeFragment)
        }

    }
    override fun bindData() {
        binding.txtviewErrorNotFound.visibility = View.GONE
        viewModel.getAllTopic()
        viewModel.TopicResults.observe(viewLifecycleOwner){
            Log.e("TopicFragment", "bindData: dữ liệu lấy liên tục: ${it} ", )
            if(it!=null){
                list = it
                binding.listTopic.adapter = topicAdapter
                binding.listTopic.layoutManager = LinearLayoutManager(context)
                topicAdapter.submitList(it.hasItem())
                Log.e("TopicFragment", "bindData: dữ liệu sau khi lấy: ${viewModel.TopicResults.value} ", )
            }
        }
    }
    private fun onClick(topic: DataTopicAPI) {
        sharedPreferences.saveIdTopic(topic.idTopic, topic.nameTopic.toString())
        Toast.makeText(context, "Đã chọn topic ${topic.nameTopic}", Toast.LENGTH_SHORT).show()
    }

}