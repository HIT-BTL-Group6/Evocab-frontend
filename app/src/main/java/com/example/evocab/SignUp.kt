package com.example.evocab

import android.content.Intent
import android.view.View
import com.example.evocab.databinding.ActivitySignUpBinding
import com.example.sourcebase.base.BaseActivity

class SignUp : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {
    override fun initData() {
        binding.usernameErrorMess.setVisibility(View.GONE)
        binding.passwErrorMess.setVisibility(View.GONE)
        binding.emailErrorMess.setVisibility(View.GONE)
    }

    override fun handleEvent() {
        binding.txtLoginChangeActi.setOnClickListener {
            startActivity(Intent(this,LogIn::class.java))
        }
    }

    override fun bindData() {

    }

}