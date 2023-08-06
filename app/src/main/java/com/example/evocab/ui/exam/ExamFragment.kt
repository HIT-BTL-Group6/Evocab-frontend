package com.example.evocab.ui.exam

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evocab.databinding.FragmentExamBinding
import com.example.evocab.model.Practice
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

    }

    override fun bindData() {
        binding.btnFinishExam.visibility = View.GONE
        val o1 = Practice("1")
        val o2 = Practice("2")
        val o3 = Practice("3")
        val o4 = Practice("4")
        val o5 = Practice("5")
        val o6 = Practice("6")
        val vocabs= listOf(o1, o2, o3, o4, o5, o6)
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