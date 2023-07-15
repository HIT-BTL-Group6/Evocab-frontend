package com.example.evocab.ui.login

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.evocab.R
import com.example.evocab.databinding.FragmentLogInBinding
import com.example.sourcebase.base.BaseFragment

class LogInFragment : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate) {

    override fun destroy() {
        super.onDestroy()
    }

    override fun initData() {


    }

    override fun handleEvent() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_settingFragment)
        }
        binding.txtSignupChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }
        binding.txtForgotPassChangeActi.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_forgotPassFragment)
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.inputPass.setBackgroundResource(R.drawable.bg_input_error)
                binding.inputUsername.setBackgroundResource(R.drawable.bg_input_error)
            } else {
                binding.inputPass.setBackgroundResource(R.drawable.bg_input)
                binding.inputUsername.setBackgroundResource(R.drawable.bg_input)
            }
        }
    }

    override fun bindData() {
        binding.usernameErrorMess.setVisibility(View.GONE)
        binding.passwErrorMess.setVisibility(View.GONE)
    }

    override val viewModel: LoginViewModel
        get() = ViewModelProvider(this)[LoginViewModel::class.java]


}