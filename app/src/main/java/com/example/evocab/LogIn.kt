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
        binding.txtSignupChangeActi.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        binding.txtForgotPassChangeActi.setOnClickListener {
            startActivity(Intent(this, ForgotPassword::class.java))
        }
    }

    override fun bindData() {

    }

}