package com.example.evocab.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentHomeBinding
import com.example.sourcebase.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }

        binding.flMissed.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
        }
        binding.flNewFlashCard.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_flashCardFragment)
        }
        binding.flPractice.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_)
        }
        binding.flClassroom.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
        }
        binding.flTopic.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
        }
        binding.flTest.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
        }
        binding.imvUserAvt.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.tvTopicName.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }




    }

    override fun bindData() {
    }
}