package com.example.evocab.ui.exam

import android.app.Dialog
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.R
import com.example.evocab.databinding.FragmentExamBinding
import com.example.evocab.extension.opDlVerifyPractice
import com.example.evocab.extension.openDlNoted
import com.example.evocab.extension.openDlReport
import com.example.evocab.model.Practice
import com.example.evocab.ui.practice.ChooseAnswerFragment
import com.example.sourcebase.base.BaseFragment

class ExamFragment : BaseFragment<FragmentExamBinding>(FragmentExamBinding::inflate) {
    private val examAdapter by lazy {
        ListAdapterExam(::onClick)
    }
    override val viewModel: ExamViewModel
        get() = ViewModelProvider(this)[ExamViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {

    }

    override fun handleEvent() {
        val dialog = context?.let { it1 -> Dialog(it1) }
        binding.apply {
            imgClose.setOnClickListener {
                findNavController().navigate(R.id.action_examFragment_to_homeFragment)
            }
            imgEdit.setOnClickListener {
                dialog?.openDlNoted()
            }
            contrainsLReport.setOnClickListener {
                dialog?.openDlReport()
            }
        }
    }

    override fun bindData() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.practice_screen_change, ChooseAnswerFragment()).commit()
        val dialog = context?.let { it1 -> Dialog(it1) }
        dialog?.opDlVerifyPractice()
        binding.btnFinishExam.visibility = View.GONE
        val o1 = Practice("1")
        val o2 = Practice("2")
        val o3 = Practice("3")
        val o4 = Practice("4")
        val o5 = Practice("5")
        val o6 = Practice("6")
        val o7 = Practice("7")
        val o8 = Practice("8")
        val o9 = Practice("9")
        val vocabs= listOf(o1, o2, o3, o4, o5, o6, o7, o8, o9)
        examAdapter.submitList(vocabs)
        binding.navQues.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        examAdapter.submitList(vocabs)
        binding.navQues.adapter = examAdapter
    }
    private fun onClick(vocabulary: Practice) {
        Toast.makeText(context, "Item lớn", Toast.LENGTH_SHORT).show()
        Log.e("chạm", "đã chạm item")
    }
}