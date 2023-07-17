package com.example.evocab.ui.report

import androidx.lifecycle.ViewModelProvider
import com.example.evocab.databinding.FragmentSettingBinding
import com.example.sourcebase.base.BaseFragment

class ReportFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    override val viewModel: ReportViewModel
        get() = ViewModelProvider(this)[ReportViewModel::class.java]

    override fun destroy() {

    }

    override fun initData() {

    }

    override fun handleEvent() {

    }

    override fun bindData() {

    }

}