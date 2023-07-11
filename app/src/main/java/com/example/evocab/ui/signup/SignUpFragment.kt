package com.example.evocab.ui.signup

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentSignUpBinding
import com.example.sourcebase.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override val viewModel: SignupViewModel
        get() = ViewModelProvider(this)[SignupViewModel::class.java]

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {

    }

    override fun handleEvent() {
        binding.txtLoginChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }
    }

    override fun bindData() {
        binding.usernameErrorMess.setVisibility(View.GONE)
        binding.passwErrorMess.setVisibility(View.GONE)
        binding.emailErrorMess.setVisibility(View.GONE)
    }


}