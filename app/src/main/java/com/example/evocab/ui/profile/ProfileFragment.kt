package com.example.evocab.ui.profile
import androidx.lifecycle.ViewModelProvider
import com.example.evocab.databinding.FragmentProfileBinding
import com.example.sourcebase.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override val viewModel: ProfileViewModel
        get() = ViewModelProvider(this)[ProfileViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {
    }

    override fun handleEvent() {
    }

    override fun bindData() {
    }
}