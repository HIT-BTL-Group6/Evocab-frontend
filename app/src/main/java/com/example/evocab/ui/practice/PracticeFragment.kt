package com.example.evocab.ui.practice

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.databinding.FragmentPracticeBinding
import com.example.evocab.model.Practice
import com.example.evocab.ui.exam.ListAdapterExam
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
        binding.btnCheckAnswer.setOnClickListener {
            findNavController().navigate(R.id.action_practiceFragment_to_examFragment)
        }
    }

    override fun bindData() {
    }
}