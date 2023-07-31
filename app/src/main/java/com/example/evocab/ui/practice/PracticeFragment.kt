package com.example.evocab.ui.practice

import androidx.lifecycle.ViewModelProvider
import com.example.evocab.R
import com.example.evocab.databinding.FragmentPracticeBinding
import com.example.sourcebase.base.BaseFragment

class PracticeFragment : BaseFragment<FragmentPracticeBinding>(FragmentPracticeBinding::inflate) {
    override val viewModel: PracticeViewModel
        get() = ViewModelProvider(this)[PracticeViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.practice_screen_change, ChooseAnswerFragment()).commit()
    }

    override fun handleEvent() {

    }

    override fun bindData() {

    }
}