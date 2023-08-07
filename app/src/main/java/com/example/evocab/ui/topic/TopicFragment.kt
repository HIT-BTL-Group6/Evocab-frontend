package com.example.evocab.ui.topic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentTopicBinding
import com.example.evocab.model.Friend
import com.example.evocab.model.Topic
import com.example.evocab.ui.profile.ProfileAdapter
import com.example.evocab.ui.profile.ProfileViewModel
import com.example.sourcebase.base.BaseFragment

class TopicFragment :BaseFragment<FragmentTopicBinding>(FragmentTopicBinding::inflate) {

    // cái này để làm gì
    private val topicAdapter by lazy {
        TopicAdapter{ {} }
    }

    override val viewModel: BaseViewModel
        get() = ViewModelProvider(this)[TopicViewModel::class.java]

    override fun destroy() {
        super.onDestroy()

    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.imgTopicBack.setOnClickListener {
            findNavController().navigate(R.id.action_topicFragment_to_homeFragment)
        }
        binding.imgTopicBack.setOnClickListener {
            findNavController().navigate(R.id.action_topicFragment_to_settingFragment)
        }
    }

    override fun bindData() {
        val v1: Topic = Topic(1, "Friend", "sdsdfs")
        val v2: Topic = Topic(2, "vacation", "sdsdfs")
        val v3: Topic = Topic(2, "vacation", "sdsdfs")
        val v4: Topic = Topic(2, "vacation", "sdsdfs")
        val v5: Topic = Topic(2, "vacation", "sdsdfs")
        val topics= listOf(v1, v2, v3, v4,v5)
        topicAdapter.submitList(topics)
        binding.listTopic.layoutManager = LinearLayoutManager(context)
        binding.listTopic.adapter = topicAdapter

    }
}