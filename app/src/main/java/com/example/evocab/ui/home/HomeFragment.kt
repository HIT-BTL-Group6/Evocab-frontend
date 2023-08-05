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
        binding.apply {
            btnSettings.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
            }
            btnMissed.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
            }
            btnFlashcard.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_flashCardFragment)
            }
            btnClassroom.setOnClickListener {
                //findNavController().navigate(R.id.)
            }
            btnTest.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_examFragment)
            }
            btnTopic.setOnClickListener {

            }
            btnRemembered.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_missedFragment)
            }
            btnPractice.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_practiceFragment)
            }
        }




    }

    override fun bindData() {
    }
}