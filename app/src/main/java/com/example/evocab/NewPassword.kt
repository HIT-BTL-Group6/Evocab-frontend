package com.example.evocab

import android.content.Intent
import android.view.View
import com.example.evocab.databinding.ActivityNewPasswordBinding
import com.example.sourcebase.base.BaseActivity

class NewPassword : BaseActivity<ActivityNewPasswordBinding>(ActivityNewPasswordBinding::inflate) {
    override fun initData() {
        binding.passwErrorMess.setVisibility(View.GONE)
        binding.passwAgainErrorMess.setVisibility(View.GONE)
    }

    override fun handleEvent() {
        binding.btnSend.setOnClickListener {

        }
        binding.txtLoginChangeActi.setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }
        binding.txtSignupChangeActi.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
    }

    override fun bindData() {

    }

}