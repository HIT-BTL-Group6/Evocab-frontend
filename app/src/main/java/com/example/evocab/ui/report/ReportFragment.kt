package com.example.evocab.ui.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.evocab.base.BaseViewModel
import com.example.evocab.databinding.FragmentReportBinding
import com.example.sourcebase.base.BaseFragment

class ReportFragment : BaseFragment<FragmentReportBinding>(FragmentReportBinding::inflate) {
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