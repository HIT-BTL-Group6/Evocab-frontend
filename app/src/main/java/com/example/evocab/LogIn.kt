package com.example.evocab

import android.content.Intent
import android.view.View
import com.example.evocab.databinding.ActivityLoginBinding
import com.example.sourcebase.base.BaseActivity

class LogIn : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun initData() {
        binding.usernameErrorMess.setVisibility(View.GONE)
        binding.passwErrorMess.setVisibility(View.GONE)
    }

    override fun handleEvent() {
        binding.btnLogin.setOnClickListener {

        }
        binding.txtSignupChangeActi.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        binding.txtForgotPassChangeActi.setOnClickListener {
            startActivity(Intent(this, ForgotPassword::class.java))
        }
        binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                binding.inputPass.setBackgroundResource(R.drawable.bg_input_error)
                binding.inputUsername.setBackgroundResource(R.drawable.bg_input_error)
            }else{
                binding.inputPass.setBackgroundResource(R.drawable.bg_input)
                binding.inputUsername.setBackgroundResource(R.drawable.bg_input)
            }
        }
    }

    override fun bindData() {

    }

}