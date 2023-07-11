package com.example.evocab.ui.newpass

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentNewPassBinding
import com.example.sourcebase.base.BaseFragment

class NewPassFragment : BaseFragment<FragmentNewPassBinding>(FragmentNewPassBinding::inflate) {
    override val viewModel:NewPassViewModel
        get() = ViewModelProvider(this)[NewPassViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {

    }

    override fun handleEvent() {
        binding.btnSend.setOnClickListener {

        }
        binding.txtLoginChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_newPassFragment_to_logInFragment)
        }
        binding.txtSignupChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_newPassFragment_to_signUpFragment)
        }
    }

    override fun bindData() {
        binding.passwErrorMess.setVisibility(View.GONE)
        binding.passwAgainErrorMess.setVisibility(View.GONE)
    }

}