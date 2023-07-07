package com.example.evocab

import android.content.Intent
import com.example.evocab.databinding.ActivityLoginBinding
import com.example.sourcebase.base.BaseActivity

class LogIn : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun initData() {
        binding.txtSignupChangeActi.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
    }

    override fun handleEvent() {

    }

    override fun bindData() {

    }

}